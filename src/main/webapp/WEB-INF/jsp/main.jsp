<%@ page import="com.example.librarysystem2.domain.member.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form class="needs-validation" action="/signin" method="GET">
    <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">로그인</button>
</form>
<form class="needs-validation" action="/signup" method="GET">
    <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
</form>

<form class="needs-validation" action="/userUpdate" method="GET">
    <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원수정</button>
</form>

<form class="needs-validation" action="/userDelete" method="POST">
    <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원탈퇴</button>
</form>

<%
    session=request.getSession();
    session=request.getSession(true);
    Member member = (Member)session.getAttribute("member");


    if(member!=null){
        out.println("session값: "+member.getEmail());
        out.println("session값: "+member.getName());
        out.println("session값: "+member.getPhone());
    }


%>
</body>
</html>