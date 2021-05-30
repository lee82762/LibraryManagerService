<%@ page import="com.example.librarysystem2.domain.manage.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<%--        mainhome header--%>
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #808080; color:white;">
    <div class="container">
        <div class="flex-md-column">
            <a style="color: white; font-size: xx-large; " class="navbar-brand" >도서관리시스템</a>
            <p class="lead"></p>
        </div>
        <div class="flex-md-row-reverse" id="navbarSupportedContent">
            <ul class="navbar-nav " style="align-items: end">
            </ul>
        </div>
    </div>



    <%
        session=request.getSession();
        //session=request.getSession(true);
        Member memberInfo = (Member) session.getAttribute("member");
        if(memberInfo==null){

    %>
    <form class="needs-validation" action="/signin" method="GET">
        <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>
    <form class="needs-validation" action="/signup" method="GET">
        <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
    </form>

    <% }else{ %>

    <form class="needs-validation" action="/signout" method="GET">
        <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">로그아웃</button>
    </form>


    <form class="needs-validation" action="/userUpdate" method="GET">
        <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원수정</button>
    </form>

    <form class="needs-validation" action="/userDelete" method="POST">
        <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">회원탈퇴</button>
    </form>

    <% } %>
</nav>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>