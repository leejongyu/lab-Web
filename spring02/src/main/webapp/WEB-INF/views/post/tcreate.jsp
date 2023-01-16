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
</style>
</head>
<body>
    <div class="container-fluid">
        <header class="my-2 p-4 text-center">
            <h1>Spring02 Main PAGE &amp; MyBatis</h1>
            <h2>템플릿 - create</h2>

        </header>
    </div>

    <nav>
        <ul class="nav my-4 bg-light">
            <li class="nav-item"><c:url var="tlist" value="/post/tlist"></c:url>
                <a class="nav-link" href="${tlist}">글목록보기</a></li>
            <li class="nav-item disabled"><c:url var="#" value="#"></c:url>
                <a class="nav-link" href="#">링크 2</a></li>
            <li class="nav-item disabled"><c:url var="#" value="#"></c:url>
                <a class="nav-link" href="#">링크 3</a></li>
            <li class="nav-item disabled"><c:url var="#" value="#"></c:url>
                <a class="nav-link" href="#">링크 4</a></li>
        </ul>
    </nav>

    <main>
        <div class = "card m-4">
            <form class = "m-4" method="post">
                <div class= "my-2">
                    <label for = "title" class= "form-label">제목</label> <input type="text" name="title" id = "title" class = "form-control" required autofocus />
                </div>
                <div class= "my-2">
                    <label for = "content" class= "form-label">내용</label> <textarea name="content" id="content"  id = "content" class = "form-control" required ></textarea>
                </div>
                <div class= "my-2">
                    <label for = "author" class= "form-label">작성자</label> <input type="text" name="author" id = "author" class = "form-control" required />
                </div>
                <div class= "my-2">
                    <input type="submit" class = "form-control" value="작성 완료" />
                </div>
    
    
            </form>
        </div>  

    </main>
    
    

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>


</body>
</html>