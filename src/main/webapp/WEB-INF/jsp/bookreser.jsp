<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %>

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
                <a class="nav-link" href="/booklistcheck">??????</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bookrental">??????</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/bookreturn">??????</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/bookreser">??????</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" >
                    ???????????????
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                    <a class="dropdown-item" href="/mybookreser">?????? ??????</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/userUpdate">?????? ?????? ??????</a>
                    <form name="userDelete" class="needs-validation" action="/userDelete" method="POST">
                        <input type="hidden" type="submit"></input>
                    </form>
                    <a class="dropdown-item"  href="#" onclick="javascript:document.userDelete.submit();">?????? ??????</a>
                </div>
            </li>
        </ul>
        <%--       <div class="float-right" style= "display: flex; justify-content: right;">
                   <form class="needs-validation" action="/signin" method="GET">
                   <button type="button" class="btn btn-outline-primary float-right" onClick="location.href='/signin'">?????????</button>
                   </form>

                   <form class="needs-validation" action="/signup" method="GET">
                   <button type="button" class="btn btn-primary float-right" onClick="location.href='/signup'">????????????</button>
                   </form>

               </div>--%>
        <%
            session=request.getSession();
            //session=request.getSession(true);
            Member memberInfo = (Member) session.getAttribute("member");
            if(memberInfo==null){

        %>
        <form class="needs-validation" action="/signin" method="GET">
            <button class="btn btn-primary float-right" type="submit">?????????</button>
        </form>
        <form class="needs-validation" action="/signup" method="GET">
            <button class="btn btn-primary float-right" type="submit">????????????</button>
        </form>

        <% }else{ %>
        <marquee  width="300" height="50"> <% if(memberInfo!=null) out.print(memberInfo.getName()+"?????? ????????? ????????????. "); %> </marquee>

        <form class="needs-validation" action="/signout" method="GET">
            <button class="btn btn-primary float-right" type="submit">????????????</button>
        </form>

        <% } %>
    </div>
</nav>



<div class="container-fluid">

    <div class="row">


        <div class="col-md-3">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h2 class="panel-title"> ?????? </h2>
                </div>
                <form action="/booklistcheck" method="get">
                    <ul class="list-group">

                        <button class="list-group-item" name="item" value=""> ???????????? </button>
                    </ul>
                </form>
                <form action="/check1" method="post">
                    <ul class="list-group">
                        <button class="list-group-item" name="item" value="????????????">???????????? </button>
                        <button class="list-group-item" name="item" value="????????????"> ???????????? </button>
                        <button class="list-group-item" name="item" value="????????????">????????????</button>
                        <button class="list-group-item" name="item" value="????????????"> ???????????? </button>
                        <button class="list-group-item" name="item" value="??????"> ?????? </button>
                    </ul>
                </form>

            </div>
        </div>

        <div class="col-md-9">
            <form action="/check" method="post">
                <td>
                    <input type="text" name="info">
                    <input type="submit" value="??????">
                </td>
                <td>
                    <input type="checkbox" name="item" value="book_name" onclick="oneCheckbox(this)">??????
                    <input type="checkbox" name="item" value="author" onclick="oneCheckbox(this)">?????????
                    <input type="checkbox" name="item" value="publisher" onclick="oneCheckbox(this)">?????????

                </td>
            </form>

            <table class="table">
                <tbody>

                <tr>
                    <c:forEach var="book" items="${booklist}" varStatus="status">

                            <figure class="figure">
                                <img src=${book.book_img} width="151.5", height="200" hspace="10">
                                <figcaption class="figure-caption">
                                    ??????: ${book.book_name} <br>
                                    ??????: ${book.author}<br>
                                    ?????????: ${book.publisher}<br>
                                    ??????: <button>${book.book_state}</button>
                                </figcaption>

                                <form action="/bookrentalcheck" method="post">
                                    ??????:<button name="bookname" value="${book.book_name}"> ?????? </button>
                                </form>
                                <form action="/bookresercheck" method="post">
                                    ??????:<button name="bookname" value="${book.book_name}"> ?????? </button>
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