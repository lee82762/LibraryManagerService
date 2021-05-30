<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> <meta charset="EUC-KR"> </head>
<body>
<h1> 책정보 </h1>
<script>
    function btn(){
        alert('버튼이 클릭되었습니다');

    }
</script>

<%--<form action="/check" method="post">
    <input type="text" name="bookinfo">검색<br>
    <input type="checkbox" name="lang" value="Java">자바
    <input type="checkbox" name="lang" value="C">C
    <input type="checkbox" name="lang" value="Cpp">C++
    <input type="checkbox" name="lang" value="Cs">C#
    <button class="btn btn-primary btn-lg btn-block" type="submit">제출</button>
</form>--%>


<form action="/check" method="post">
    <td>
        <input type="text" name="info">
        <input type="submit" value="검색">
    </td>
    <td>
        <input type="checkbox" name="item" value="book_name">제목
        <input type="checkbox" name="item" value="author">글쓴이
        <input type="checkbox" name="item" value="publisher">출판사
        <input type="checkbox" name="item" value="genre">장르
    </td>
</form>

<ul>
    <c:forEach var="book" items="${booklist}" varStatus="status">
        <li> ${status.index+1} :${book.book_name}
        <button onclick="javascript:btn()"  value="${book.book_name}"> 자세히보기 </button>
        </li>
    </c:forEach>
</ul>
<%--<img src=${book.book_img} width="500", height="250" >--%>
<%


    session=request.getSession();
    session=request.getSession(true);
    Member member = (Member)session.getAttribute("member");


    if(member!=null){
        out.println("session값: "+member.getEmail());
        out.println("session값: "+member.getName());
        out.println("session값: "+member.getPhone());
    }


%>
</body>
</html>
