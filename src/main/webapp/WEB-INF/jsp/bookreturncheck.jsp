<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-30
  Time: 오후 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    String RETURN_OK = (String) request.getAttribute("RETURN_OK");

    if(RETURN_OK.equals("success")){
        out.println("<script>alert('반납 성공!'); </script>");
        out.println("<script>location.href='/bookreturn'</script>");
    }
    else if(RETURN_OK.equals("fail")){
        out.println("<script>alert('로그인을 하세요!'); </script>");
        out.println("<script>location.href='/'</script>");
    }
%>
</body>
</html>
