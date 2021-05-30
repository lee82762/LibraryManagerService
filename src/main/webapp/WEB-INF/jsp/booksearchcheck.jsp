<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1> 검색결과 </h1>
<ul>
    <c:forEach var="book1" items="${booklist2}" varStatus="status">
        <li> ${status.index+1} :${book1.book_name}
            <button onclick="javascript:btn()"  value="${book1.book_name}"> 자세히보기 </button>
        </li>
    </c:forEach>
</ul>

<%
    String CHECK_OK = (String) request.getAttribute("CHECK_OK");
    if(CHECK_OK.equals("success")){

        //out.println("<script>location.href='/booklistcheck'</script>");
    }
%>


</body>
</html>
