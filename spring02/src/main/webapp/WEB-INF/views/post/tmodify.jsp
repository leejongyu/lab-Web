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

        <header class="my-2 p-4 text-center text-bg-secondary">
            <h1>Spring MVC &amp; MyBatis</h1>
            <h2>T-modify</h2>
        </header>

        <nav>
            <ul class="nav bg-light">
                <li class="nav-item"><c:url var="mainPage"
                        value="/"></c:url> <a class="nav-link"
                    href="${mainPage}">메인 페이지</a></li>
                <li class="nav-item"><c:url var="tlist"
                        value="/post/tlist"></c:url> <a
                    class="nav-link " href="${tlist}">목록 페이지</a></li>
                <li class="nav-item"><c:url var="tmodify"
                        value="/post/tmodify">
                        <c:param name="id" value="${post.id}"></c:param>
                    </c:url> <a class="nav-link" href="${tmodify}">수정 페이지</a></li>
            </ul>
        </nav>

        <main class="my-4">

            <div class="card">
                <div class="card-header">

                    <div class="card-body">
                        <form id="form">
                            <div class="my-2">
                                <label for="id" class="form-label">번호</label>
                                <input id="id" class="form-control"
                                    type="text" name="id"
                                    value="${post.id}" readonly />
                            </div>
                            <div>
                                <label for="title" class="form-label">제목</label>
                                <input id="title" class="form-control"
                                    type="text" name="title"
                                    value="${post.title}" />
                            </div>
                            <div>
                                <label for="content" class="form-label">내용</label>
                                <textarea id="content" name="content"
                                    class="form-control">${post.content}</textarea>
                            </div>
                            <div>
                                <label for="author" class="form-label">작성자</label>
                                <input id="author" class="form-control"
                                    type="text" value="${post.author}"
                                    readonly />
                            </div>
                            <div class="my-2">
                                <button id="btndelete"
                                    class="btn btn-danger">삭제하기</button>
                                <button id="btnupdate"
                                    class="btn btn-success">수정하기</button>
                            </div>

                        </form>
                    </div>
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

    <c:url var="tdelete" value="/post/tdelete"></c:url>
    <c:url var="tupdate" value="/post/tupdate"></c:url>
    <script>
					// id = postForm인 html 요소를 찾음
					const form = document.querySelector('#form');

					// id = btndelete인 button을 찾음
					const btndelete = document.querySelector('#btndelete');
					const btnupdate = document.querySelector('#btnupdate');

					// 버튼 클릭 이벤트 리스너를 등록
					btndelete.addEventListener('click', function(event) {
						event.preventDefault();
						const check = confirm('삭제 하시겠습니까?');

						if (check) { // 삭제 한다고 하면
							form.action = '${tdelete}'; // 제출 요청 주소
							form.method = 'post';
							form.submit();
						}
					});

					btnupdate.addEventListener('click',function(event) {
						event.preventDefault();
						const title = document.querySelector('#title').value;
						const content = document.querySelector('#content').value;
						
						if (title == '' || content == '') {
							alert('제목 혹은 내용이 비어있습니다.');
							return;
							}

						const check = confirm('수정 하시겠습니까?');

						if (check) { // 수정 한다고 하면
							form.action = '${tupdate}'; // 제출 요청 주소
							form.method = 'post';
							form.submit();
							}
					});
</script>
</body>
</html>