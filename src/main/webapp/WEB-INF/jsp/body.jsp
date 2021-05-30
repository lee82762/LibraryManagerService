<%--
  Created by IntelliJ IDEA.
  User: 이재범
  Date: 2021-05-29
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    /* 2. 수평 네비게이션 바 */
    ul{
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    /* navi 하위의 li만 선택 */
    .navi > li {
        float:left;
    }

    /* 메인메뉴의 a태그만 선택(상하, 좌우 거리) */
    .navi > li > a{
        padding: 15px 156.8px;
    }

    /* 모든 a태그 */
    li a{
        background-color: #39f;
        text-decoration: none;
        font-weight: bold;
        color: #000000;
        display: block;
        text-align: center;
        padding: 10px;
    }

    li a:hover{
        background-color: #33f;
        color: white;
    }

    /* 마우스 오버하지 않았을 때 서브메뉴가 보이지 않도록 설정 */

    /* 1. display 변경해서 설정 */
    /* li 하위의 ul = 서브메뉴 */
    /* .navi li ul {
        display: none;
    } */

    /* 마우스 커서를 올리면 서브 메뉴를 보이게 하기 */
    /* 마우스 오버했을 때 ul이 block되어 보여야 한다. */
    /* .navi li:hover ul{
        display:block;
    } */

    /* 2. 투명도를 변경해서 설정 */
    .navi li ul {
        opacity:0;
    }

    .navi li:hover ul{
        opacity:1;
        transition: all 1s;
    }


    /* 모든 a태그를 대상으로 트랜지션 설정하기 */
    .navi li a{
        transition: all 0.5s;
    }

</style>

</head>
<body>
<ul class="navi">
  <%--  <li><a href="#">도서</a>
        <ul>
            <li><a href="#">도서리스트</a></li>
            <li><a href="#">도서대출</a></li>
            <li><a href="#">도서예약</a></li>
            <li><a href="#">도서반납</a></li>
        </ul>
    </li>--%>
    <li><a href="/booklistcheck">도서리스트</a>
    <li><a href="/bookrental">도서대출</a></li>
    <li><a href="#">도서예약</a></li>
    <li><a href="/bookreturn">도서반납</a></li>
    <li><a href="#">마이페이지</a></li>
</ul>



<%--
<form class="needs-validation" action="/booklistcheck" method="GET">
    <button class="w-100 btn btn-lg btn-primary btn-block" type="submit">책리스트 보기</button>
</form>--%>

</body>
</html>
