<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList</title>
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


        <h1>USER 목록 Page</h1>


        <nav>
            <ul class="list-group">


                <%-- 로그인 정보가 있는 경우 --%>
                <!-- EL not empty 연산자: null이 아니고, 문자열인 경우 빈 문자열이 아닌 경우 -->
                <c:if test="${ not empty signInUser}">
                    <li class="list-group-item"><c:url
                            var="signout" value="/user/signout"></c:url>
                        <mark>${signInUser}</mark> <a href="${signout}">로그아웃</a></li>
                </c:if>

                <%-- 로그인 정보가 없는 경우 --%>
                <c:if test="${empty signInUser }">
                    <li class="list-group-item"><c:url var="signin"
                            value="/user/signin"></c:url> <a
                        href="${signin}">로그인</a></li>
                    <li class="list-group-item"><c:url var="create"
                            value="/user/create"></c:url> <a
                        href="${create}">회원가입</a></li>
                </c:if>

                <li class="list-group-item"><c:url var="main"
                        value="/"></c:url> <a href="${main}">메인 페이지</a></li>
                <li class="list-group-item"><c:url var="post"
                        value="post"></c:url> <a href="${post}">포스트
                        목록</a></li>

            </ul>
            <main>
                <div>
                    <c:url var="search" value="/user/search"></c:url>
                    <form method="get" action="${search}" id="form1">
                        <select name="type">
                            <option value="n">이름</option>
                            <option value="m">이메일</option>
                            <option value="nm">이름 + 이메일</option>
                        </select> <input type="text" name="keyword"
                            placeholder="검색어를 입력하세요" required /> <input
                            type="submit" />
                    </form>
                </div>
                <table class="table">
                    <thead>
                        <tr class="table-info">
                            <th class="table-info">고유번호</th>
                            <th class="table-info">이름</th>
                            <th class="table-info">이메일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${users}">
                            <tr>
                                <td>${u.id}</td>
                                <td><c:url var="detail"
                                        value="/user/detail">
                                        <c:param name="id"
                                            value="${u.id}"></c:param>
                                    </c:url> <a href="${detail}">${u.name}</a></td>
                                <td>${u.email}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>
        </nav>



    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
					
				</script>


</body>
</html>