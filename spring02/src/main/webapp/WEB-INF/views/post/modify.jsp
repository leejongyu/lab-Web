<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modify~</title>
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
        <h1>페이지 수정 페이지</h1>

        <nav>
            <ul class="list-group">

                <li class="list-group-item"><c:url var="main"
                        value="/"></c:url> <a href="${main}">메인 페이지</a></li>
                <li class="list-group-item"><c:url var="list"
                        value="/post/list"></c:url> <a href="${list}">목록
                        페이지</a></li>
                <li class="list-group-item"><c:url var="detail"
                        value="/post/detail">
                        <c:param name="id" value="${post.id}"></c:param>
                    </c:url> <a href="${detail}">글 상세보기</a></li>
            </ul>
        </nav>

        <main>
            <form id="postForm">
                <!-- action : submit 대상 주소, method : submit 방식 -->
                <div class="form-floating">
                    <input id="id" type="number" name="id"
                        value="${post.id}" readonly class="form-control" />
                    <label for="id">번호</label>
                </div>
                <div class="form-floating">
                    <input id="title" type="text" name="title"
                        value="${post.title}" required autofocus
                        class="form-control" /> <label for="title">제목</label>
                </div>
                <div class="form-floating">

                    <textarea style="height: 300px" id="content"
                        name="content" required class="form-control">${post.content}  </textarea>
                    <label for="content">본문</label>
                </div>

                <div class="form-floating">
                    <input id="author" type="text"
                        value="${post.author}" readonly
                        class="form-control" /><label for="author">작성자</label>
                </div>


                <div>
                    <!-- form 안에 있는 button은 form의 action 주소로 method 방식의 요청을 보냄. -->
                    <button id="btndelete"
                        class="btn btn-outline-primary">삭제</button>
                    <button id="btnupdate"
                        class="btn btn-outline-primary">수정</button>
                    <!-- name이 있는 요소들만 전달됨. -->
                </div>


            </form>
        </main>
    </div>

    <c:url var="delete" value="/post/delete"></c:url>
    <c:url var="update" value="/post/update"></c:url>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
    <script 
        src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
    <script>
					// id = postForm인 html 요소를 찾음
					const form = document.querySelector('#postForm');

					// id = btndelete인 button을 찾음
					const btndelete = document.querySelector('#btndelete');
					const btnupdate = document.querySelector('#btnupdate');

					// 버튼 클릭 이벤트 리스너를 등록
					btndelete.addEventListener('click', function(event) {
						event.preventDefault();
						const check = confirm('삭제 하시겠습니까?');

						if (check) { // 삭제 한다고 하면
							form.action = '${delete}'; // 제출 요청 주소
							form.method = 'post';
							form.submit();
						}
					});

					btnupdate.addEventListener('click', function(event) {
						event.preventDefault();
						const title = document.querySelector('#title').value;
						const content = document.querySelector('#content').value;

						if (title == '' || content == '') {
						alert('제목 혹은 내용이 비어있습니다.');
						return;
						}

						const check = confirm('수정 하시겠습니까?');

						if (check) { // 수정 한다고 하면
						form.action = '${update}'; // 제출 요청 주소
						form.method = 'post';
						form.submit();
						}

					});
				</script>

</body>
</html>