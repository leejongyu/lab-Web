<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring 2</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
li {
    text-align: center;
}

a {
    text-decoration: none;
}
</style>
</head>
<body>
    <div class="container-fluid">
        <header class="my-2 p-4 text-center">
            <h2>메인 페이지</h2>
        </header>
    </div>

    <nav>
        <ul class="list-group">
            <li class="list-group-item">
            <c:url var="list" value="/post/list"></c:url> 
            <a href="${list}">글 목록보기</a></li>
            <li class="list-group-item">
            <c:url var="create" value="/post/create"></c:url>
            <a href="${create}">새 글 작성</a></li>
            <li class="list-group-item">
            <c:url var="user" value="/user/list"></c:url> 
            <a href="${user}">유저 목록</a></li>
            <li class="list-group-item">
            <c:url var="tlist" value="/post/tlist"></c:url> 
            <a href="${tlist}">템플릿</a></li>
            <li class="list-group-item">
            <c:url var="signin" value="/user/signin"></c:url> 
            <a href="${signin}">로그인</a></li>
        </ul>
    </nav>

    <main></main>


    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>


</body>
</html>