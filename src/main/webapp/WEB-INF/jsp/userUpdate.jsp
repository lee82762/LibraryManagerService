<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %><%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-28
  Time: 오후 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<h2>수정페이지</h2>

<%
    session=request.getSession();
    session=request.getSession(true);
    Member memberInfo = (Member) session.getAttribute("member");
    out.print(memberInfo.getEmail());
    out.print(memberInfo.getName());
%>

<form action="/userUpdatecheck" method="post">
    아이디 : <input type="text" name="address" value="<%=memberInfo.getEmail()%>"> <br>
    비밀번호 : <input type="text" name="password" value=""> <br>
    이름: <input type="text" name="name" value=""> <br>
    핸드폰번호 : <input type="text" name="phone" value=""><br>
    <input type="submit" value="수정">
</form>


</body>
</html>
