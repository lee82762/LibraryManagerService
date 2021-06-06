<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %><%--<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %>&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-30
  Time: 오후 8:52
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 도서 반납 </h1>

<%
    session=request.getSession();
    session=request.getSession(true);
    Member member = (Member)session.getAttribute("member");


    if(member==null){
        out.println("<script>alert('로그인 하세요!'); </script>");
        out.println("<script>location.href='/signin'</script>");
    }
%>
<ul>
    <c:forEach var="book" items="${mybook}" varStatus="status">
        <form action="/bookreturncheck" method="post">
            <li> ${status.index+1} :${book.book_name}
                <button name="bookname" value="${book.book_name}"> 반납 </button>
            </li>
        </form>
    </c:forEach>
</ul>
<button onclick="location.href='/'"> 돌아가기 </button>
</body>
</html>--%>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Adding Dropdowns in Bootstrap 4 via Data Attributes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function oneCheckbox(a){
            var obj = document.getElementsByName("item");
            for(var i=0; i<obj.length; i++){
                if(obj[i] != a){
                    obj[i].checked = false;
                }
            }
        }
    </script>

    <style>

        .container-fluid{
            margin-top: 150px;
        }
        .table{
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<%
    session=request.getSession();
    session=request.getSession(true);
    Member member = (Member)session.getAttribute("member");


    if(member==null){
        out.println("<script>alert('로그인 하세요!'); </script>");
        out.println("<script>location.href='/signin'</script>");
    }
%>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="#">
        <a href="/"><img src="${pageContext.request.contextPath}/image/libraryIconjpg.jpg" width="50" height="50" alt="" >
        </a>
        Library System
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/booklistcheck">검색</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bookrental">대출</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/bookreturn">반납</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bookreser">예약</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" >
                    마이페이지
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/mybookreser">예약 현황</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/userUpdate">회원 정보 수정</a>
                    <form name="userDelete" class="needs-validation" action="/userDelete" method="POST">
                        <input type="hidden" type="submit"></input>
                    </form>
                    <a class="dropdown-item"  href="#" onclick="javascript:document.userDelete.submit();">회원 탈퇴</a>
                </div>
            </li>
        </ul>
        <%--       <div class="float-right" style= "display: flex; justify-content: right;">
                   <form class="needs-validation" action="/signin" method="GET">
                   <button type="button" class="btn btn-outline-primary float-right" onClick="location.href='/signin'">로그인</button>
                   </form>

                   <form class="needs-validation" action="/signup" method="GET">
                   <button type="button" class="btn btn-primary float-right" onClick="location.href='/signup'">회원가입</button>
                   </form>

               </div>--%>
        <%
            session=request.getSession();
            //session=request.getSession(true);
            Member memberInfo = (Member) session.getAttribute("member");
            if(memberInfo==null){

        %>
        <form class="needs-validation" action="/signin" method="GET">
            <button class="btn btn-primary float-right" type="submit">로그인</button>
        </form>
        <form class="needs-validation" action="/signup" method="GET">
            <button class="btn btn-primary float-right" type="submit">회원가입</button>
        </form>

        <% }else{ %>
        <marquee  width="300" height="50"> <% if(memberInfo!=null) out.print(memberInfo.getName()+"님이 로그인 중입니다. "); %> </marquee>
        <form class="needs-validation" action="/signout" method="GET">
            <button class="btn btn-primary float-right" type="submit">로그아웃</button>
        </form>
        <%--

                <form class="needs-validation" action="/userUpdate" method="GET">
                    <button class="btn btn-primary float-right" type="submit">회원수정</button>
                </form>

                <form class="needs-validation" action="/userDelete" method="POST">
                    <button  type="submit">회원탈퇴</button>
                </form>--%>

        <% } %>
    </div>
</nav>



<div class="container-fluid">

    <div class="row">


        <div class="col-md-9">

            <table class="table">
                <tbody>

                <tr>
                    <% if (member==null){
                        out.println("<script>alert('로그인을 하세요!'); </script>");
                        out.println("<script>location.href='/signin'</script>");
                    }
                    else{
                    %>
                    <h3><%=member.getName()%>님의 예약도서</h3>
                    <% }%>
                    <c:forEach var="book" items="${mybook}" varStatus="status">

                        <figure class="figure">
                            <img src=${book.book_img} width="151.5", height="200" hspace="10">
                            <figcaption class="figure-caption">
                                이름: ${book.book_name} <br>
                                저자: ${book.author}<br>
                                출판사: ${book.publisher}<br>
                            </figcaption>

                            <form action="/bookrentalcheck" method="post">
                                대출:<button name="bookname" value="${book.book_name}"> 대출 </button>
                            </form>

                        </figure>

                    </c:forEach>
                </tr>



                </tbody>
            </table>

        </div>
    </div>
</div>
</div>

<%--</form>--%>

</body>
</html>
