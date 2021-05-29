<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-29
  Time: 오후 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<%
    String CHECK_OK = (String) request.getAttribute("CHECK_OK");
    if(CHECK_OK.equals("success")){
        out.println("<script>location.href='/booklistcheck'</script>");

    }
%>

</body>
</html>
