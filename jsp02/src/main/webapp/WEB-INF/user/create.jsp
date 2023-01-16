<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
</style>
</head>
<body>

    <div>

        <h1>회원가입</h1>

        <nav>
            <ul class="list-group">
                <li class="list-group-item"><c:url var="main"
                        value="/"></c:url> <a href="${main}">메인 페이지</a></li>
                <li class="list-group-item"><c:url var="list"
                        value="/user"></c:url> <a href="${list}">회원목록
                        페이지</a></li>
            </ul>
        </nav>
    </div>

    <main>

        <form method="post">
            <div class="form-floating">
                <input type="text" name="name" 
                    required class="form-control" id="floatingname">
                <label for="floatingname">이름을 입력하세요</label>
            </div>
            <div class="form-floating">
                <input type="password" name="password"
                    class="form-control" id="floatingPassword"
                     required /> <label
                    for="floatingPassword">Password를 입력하세요</label>
            </div>
            <div class="form-floating">
                <input type="email" name="email"
                     required
                    class="form-control" id="floatingmail" required>
                    <label for="floatingmail">메일주소를 입력하세요</label>
            </div>
            <div>
                <input type="submit" value="작성 완료" class="btn btn-outline-primary">
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