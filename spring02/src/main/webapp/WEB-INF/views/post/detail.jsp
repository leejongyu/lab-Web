<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
h1 {
    margin: 8px;
    padding: 8px;
    text-align: center;
}

li {
    text-align: center;
    list-style: none;
}

a {
    text-decoration: none;
}

main {
    text-align: center;
}
</style>
<title>JSP 2</title>
</head>
<body>
    <div>
        <h1>페이지 상세 페이지</h1>

        <nav>
            <ul class="list-group">
                <li class="list-group-item"><c:url var="list"
                        value="/post/list"></c:url> <a href="${list}">목록
                        페이지</a></li>
               
                    <li class="list-group-item"><c:url var="modify"
                            value="/post/modify">
                            <c:param name="id" value="${post.id}"></c:param>
                        </c:url> <a href="${modify}">글 수정하기</a></li>
            </ul>
        </nav>

        <main>
            <form>
                <div class="form-floating">
                    <input id="id" type="number" value="${post.id}"
                        readonly class="form-control" /> <label
                        for="id">번호</label>
                </div>
                <div class="form-floating">
                    <input id="title" type="text" value="${post.title}"
                        readonly class="form-control" /> <label
                        for="title">제목</label>
                </div>
                <div class="form-floating">

                    <textarea style="height: 300px" id="content" readonly
                        class="form-control">${post.content} </textarea>
                    <label for="content">본문</label>
                </div>
                <div class="form-floating">
                    <input id="author" type="text"
                        value="${post.author}" readonly
                        class="form-control" /> <label for="author">작성자</label>
                </div>
                <div class="form-floating">
                    <input id="createdTime" type="datetime-local"
                        value="${post.created_time}" readonly
                        class="form-control" /> <label
                        for="createdTime">작성시간</label>
                </div>
                <div class="form-floating">
                    <input id="modifiedTime" type="datetime-local"
                        value="${post.modified_time}" readonly
                        class="form-control" /> <label
                        for="modifiedTime">수정시간</label>
                </div>
            </form>
        </main>
    </div>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
                    
                </script>
                
    <script 
        src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
</body>
</html>