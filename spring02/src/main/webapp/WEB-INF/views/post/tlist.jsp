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
</head>
<body>

    <div>
        <ul class="list-group">

            <li class="list-group-item"><c:url var="main" value="/"></c:url>
                <a href="${main}">메인 페이지</a></li>

            <li class="list-group-item"><c:url var="tcreate"
                    value="/post/tcreate"></c:url> <a href="${tcreate}">새
                    글 작성</a></li>

        </ul>
        <main class="my-2">

            <div class="bg-light my-2 p-2">
                <c:url var="search" value="/post/search"></c:url>
                <form action="${search}" method="get">
                    <div class="row">
                        <div class="col-2">
                            <select name="type" class="form-control">
                                <option value="t">제목</option>
                                <option value="c">내용</option>
                                <option value="a">작성자</option>
                                <option value="tc">제목+내용</option>
                            </select>
                        </div>
                        <div class="col-8">
                            <input type="text" class="form-control"
                                name="keyword" placeholder="검색어를 입력하세요"
                                required autofocus />
                        </div>
                        <div class="col-2">
                            <input type="submit" class="form-control btn btn-outline-success"
                                value="검색" />
                        </div>
                    </div>
                </form>
            </div>


            <div class="card my-2">
                <table class="table table-hover">
                    <thead>
                        <tr class="table-primary">
                            <th class="table-primary">번호</th>
                            <th class="table-primary">제목</th>
                            <th class="table-primary">작성자</th>
                            <th class="table-primary">수정시간</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="l" items="${list}">
                            <tr>
                                <td>${l.id}</td>
                                <td><c:url var="detail"
                                        value="/post/tdetail">
                                        <c:param name="id"
                                            value="${l.id}"></c:param>
                                    </c:url> <a href="${detail}">${l.title}</a>
                                <td>${l.author}</td>
                                <td>${l.modified_time}</td>
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
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
</body>
</html>