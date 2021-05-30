<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %><%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-28
  Time: 오후 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%

session=request.getSession();
session=request.getSession(true);
session.invalidate();
out.println("<script>alert('로그아웃 성공!'); </script>");
out.println("<script>location.href='/'</script>");

%>

</body>
</html>
