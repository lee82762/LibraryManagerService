<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    session=request.getSession();
    session=request.getSession(true);
    Member member = (Member)session.getAttribute("member");


%>

</body>
</html>