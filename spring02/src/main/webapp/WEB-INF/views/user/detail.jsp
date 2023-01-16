<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Spring 2</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous" />
</head>
<body>

    <div class="container-fluid">

        <nav>
            <ul class="nav bg-light">
                <li class="nav-item">
                <c:url var="mainPage" value="/"></c:url> 
                <a class="nav-link" href="${mainPage}">메인 페이지</a></li>
                <li class="nav-item">
                <c:url var="list" value="/user/list"></c:url> 
                <a class="nav-link " href="${list}">목록 페이지</a></li>
                <li class="nav-item">
                <c:url var="modify" value="/user/modify">
                <c:param name="id" value="${user.id}"></c:param></c:url> 
                <a class="nav-link" href="${modify}">수정 페이지</a></li>
            </ul>
        </nav>

        <main class="my-4">

            <div class="card">
                <div class="card-header"></div>
                <div class="card-body">
                    <form>
                        <div>
                            <label for="id" class="form-label">번호</label>
                            <input id="id" class="form-control" type="number" value="${user.id}" readonly />
                        </div>
                        <div>
                            <label for="name" class="form-label">이름</label>
                            <input id="name" class="form-control" type="text" value="${user.name}" readonly />
                        </div>
                         <div>
                            <label for="password" class="form-label">비밀번호</label>
                            <input id="password" class="form-control" type="text" value="${user.password}" readonly />
                        </div>
                        <div>
                            <label for="email" class="form-label">이메일</label>
                            <input id="email" class="form-control" type="text" value="${user.email}" readonly />
                        </div>
                        <div>
                            <label for="points" class="form-label">포인트</label>
                            <input id="points" class="form-control" type="number" value="${user.points}" readonly />
                        </div>
                    </form>
                </div>
            </div>

        </main>

    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
</body>
</html>