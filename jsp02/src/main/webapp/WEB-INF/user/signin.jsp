<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP2</title>
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
}
</style>
</head>
<body>
    <div>
        <div>
            <h1>로그인 페이지</h1>
        </div>
        <ul class="list-group">



            <%-- 로그인 정보가 없는 경우 --%>

                <li class="list-group-item"><c:url var="create"
                        value="/user/create"></c:url> <a
                    href="${create}">회원가입</a></li>
            

            <li class="list-group-item"><c:url var="main" value="/"></c:url>
                <a href="${main}">메인 페이지</a></li>



        </ul>
        <div>
            <form method="post">
                <div class="form-floating">
                    <input type="text" name="name" required autofocus
                        class="form-control" id="floatingname">
                    <label for="floatingname">아이디를 입력하세요</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" required
                        class="form-control" id="floatingPassword">
                    <label for="floatingPassword">Password를
                        입력하세요</label>
                </div>
                <div>
                    <input type="submit" value="로그인">
                </div>
            </form>
        </div>
    </div>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
					
				</script>
</body>
</html>