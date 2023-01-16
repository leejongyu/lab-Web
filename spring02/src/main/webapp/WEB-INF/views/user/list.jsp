<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Post List</title>
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

#form1 {
    text-align: center;
}

tr th {
    text-align: center;
}

tr td {
    text-align: center;
}
</style>
</head>
<body>

    <div>
        <ul class="list-group">

            <li class="list-group-item"><c:url var="main" value="/"></c:url>
                <a href="${main}">메인 페이지</a></li>

            <li class="list-group-item"><c:url var="create" value="/user/create"></c:url> <a href="${create}">회원가입</a></li>

        </ul>
        <main class="my-2">

            <div class="card my-2">
                <table class="table table-hover">
                    <thead>
                        <tr class="table-primary">
                            <th class="table-primary">번호</th>
                            <th class="table-primary">이름</th>
                            <th class="table-primary">포인트</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="l" items="${list}">
                            <tr>
                                <td>${l.id}</td>
                                <td><c:url var="detail" value="/user/detail">
                                    <c:param name="id" value="${l.id}"></c:param>
                                    </c:url> <a href="${detail}">${l.name}</a>
                                <td>${l.points}</td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </main>

    </div>



    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
    </script>
</body>
</html>