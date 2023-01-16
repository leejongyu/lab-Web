<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring Create</title>
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

#sub {
    align-content: center;
}

div {
    margin: 2px;
    padding: 2px;
}
</style>
</head>
<body>

    <div>
        <div class="container-fluid">
            <header class="my-2 p-4 text-center">
                <h2>새 글 작성 페이지</h2>
            </header>
        </div>

        <nav>
            <ul class="list-group">
                <li class="list-group-item"><c:url var="main"
                        value="/"></c:url> <a href="${main}">메인 페이지</a></li>
                <li class="list-group-item"><c:url var="list"
                        value="/post/list"></c:url> <a href="${list}">목록페이지</a></li>
            </ul>
        </nav>
    </div>

    <main>

        <form method="post">
            <div class="form-floating">
                <input type="text" name="title" required
                    class="form-control" id="floatingtitle"> <label
                    for="floatingtitle">제목을 입력하세요</label>
            </div>
            <div class="form-floating">
                <textarea id="floatingcontent" name="content" required
                    class="form-control" style="height: 300px"></textarea>
                <label for="floatingcontent">내용을 입력하세요</label>
            </div>
            <div class="form-floating">
                <input type="text" name="author" required
                    class="form-control" id="floatingname" required><label
                    for="floatingname">작성자 이름을 입력하세요</label>
            </div>
            <div>
                <input type="submit" value="작성 완료"
                    class="btn btn-outline-primary" id="sub">
            </div>
        </form>

    </main>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
					
				</script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
</body>
</html>