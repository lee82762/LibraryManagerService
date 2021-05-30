<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-30
  Time: 오후 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
String RENTAL_OK = (String) request.getAttribute("RENTAL_OK");
if(RENTAL_OK.equals("success")){
    out.println("<script>alert('대여 성공!'); </script>");
    out.println("<script>location.href='/bookrental'</script>");
}
else if(RENTAL_OK.equals("logincheck")){
     out.println("<script>alert('로그인을 하세요!'); </script>");
     out.println("<script>location.href='/signin'</script>");
}
else if(RENTAL_OK.equals("fail")){
    out.println("<script>alert('이미 대여중인 도서입니다!'); </script>");
out.println("<script>location.href='/bookrental'</script>");
}
%>

</body>
</html>
