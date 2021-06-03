<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-06-01
  Time: 오후 7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    String RESER_OK = (String) request.getAttribute("RESER_OK");
    if(RESER_OK.equals("success")){
        out.println("<script>alert('예약 성공!'); </script>");
        out.println("<script>location.href='/booklistcheck'</script>");
    }
    else if(RESER_OK.equals("logincheck")){
        out.println("<script>alert('로그인을 하세요!'); </script>");
        out.println("<script>location.href='/signin'</script>");
    }
    else if(RESER_OK.equals("fail")){
        out.println("<script>alert('이미 예약중인 도서입니다!'); </script>");
        out.println("<script>location.href='/booklistcheck'</script>");
    }
%>

</body>
</html>
