<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

        <h1>포스트 작성 페이지</h1>

        <nav>
            <ul class="list-group">
                <c:if test="${ not empty signInUser}">
                    <li class="list-group-item"><c:url
                            var="signout" value="/user/signout"></c:url>
                        <mark>${signInUser}</mark> <a href="${signout}">로그아웃</a></li>
                </c:if>

                <li class="list-group-item"><c:url var="main"
                        value="/"></c:url> <a href="${main}">메인 페이지</a></li>
                <li class="list-group-item"><c:url var="list"
                        value="/post"></c:url> <a href="${list}">목록페이지</a></li>

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
                <input type="hidden" name="author" required
                    class="form-control" id="floatingname"
                    value="${signInUser}" readonly>
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
</body>
</html>