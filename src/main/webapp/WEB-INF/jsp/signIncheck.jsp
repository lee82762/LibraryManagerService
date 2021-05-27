<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<BODY>
<%

    String SIGNIN_OK = (String) request.getAttribute("SIGNIN_OK");

    if(SIGNIN_OK.equals("success")){
        System.out.println("성공");
        out.println("<script>alert('로그인 성공!'); </script>");
       // out.println("<script>alert('등록되지 않은 이메일입니다! 회원가입페이지로 이동합니다..'); </script>");
        out.println("<script>location.href='/'</script>");
    }
    else{
        System.out.println("실패");
        out.println("<script>alert('등록되지 않은 이메일 혹은 패스워드 입니다! '); </script>");

        out.println("<script>location.href='/'</script>");
    }
%>

</BODY>
</HTML>
