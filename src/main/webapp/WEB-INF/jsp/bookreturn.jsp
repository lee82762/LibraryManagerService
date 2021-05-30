<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-30
  Time: 오후 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 도서 반납 </h1>
<ul>
    <c:forEach var="book" items="${mybook}" varStatus="status">
        <form action="/bookreturncheck" method="post">
            <li> ${status.index+1} :${book.book_name}
                <button name="bookname" value="${book.book_name}"> 반납 </button>
            </li>
        </form>
    </c:forEach>
</ul>

</body>
</html>
