<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
main {
    text-align: center;
}
</style>
<title>유저 정보 수정 페이지</title>
</head>
<body>
 <div>
        <h1>페이지 수정 페이지</h1>

        <nav>
            <ul>
                <li><c:url var="main" value="/"></c:url> <a
                    href="${main}">메인 페이지</a></li>
                <li><c:url var="list" value="/user"></c:url> <a
                    href="${list}">목록 페이지</a></li>
                <li><c:url var="detail" value="/user/detail">
                        <c:param name="id" value="${user.id}"></c:param>
                    </c:url> <a href="${detail}">유저 상세보기</a></li>
            </ul>
        </nav>

        <main>
            <form id="postForm">
                <!-- action : submit 대상 주소, method : submit 방식 -->
                <div>
                    <label for="id">고유번호</label> <input id="id"
                        type="number" name="id" value="${user.id}"
                        readonly /> <br />
                </div>
                <div>
                    <label for="name">이름</label> <input id="name"
                        type="text" name="name" value="${user.name}"
                        readonly/><br />
                </div>
                <div>
                    <label for="password">비밀번호</label> <input id="password"
                        type="password" name="password" value="${user.password}"
                        required autofocus/><br />
                </div>
                <div>
                    <label for="email">이메일</label> <input id="email"
                        type="email" name = "email" value="${user.email}" required /><br />
                </div>
                <div>
                    <label for="points">포인트</label> <input id="points"
                        type="number" name="points" value="${user.points}" required /> <br />
                </div>
                <div>
                    <!-- form 안에 있는 button은 form의 action 주소로 method 방식의 요청을 보냄. -->
                    <button id="btndelete">삭제</button>
                    <button id="btnupdate">수정</button>
                    <!-- name이 있는 요소들만 전달됨. -->
                </div>
            </form>
        </main>
    </div>

    <c:url var="delete" value="/user/delete"></c:url>
    <c:url var="update" value="/user/modify"></c:url>
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
                            
                            const password = document.querySelector('#password').value;
                            
                            const email = document.querySelector('#email').value;
                            
                            if(password == '' || email == ''){
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