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
                <c:url var="detail" value="/user/detail">
                <c:param name="id" value="${user.id}"></c:param></c:url> 
                <a class="nav-link" href="${detail}">상세보기 페이지</a></li>
            </ul>
        </nav>

        <main class="my-4">

            <div class="card">
                <div class="card-header"></div>
                <div class="card-body">
                    <form id="form">
                        <div>
                            <label for="id" class="form-label">번호</label>
                            <input id="id" name = "id" class="form-control" type="number" value="${user.id}" readonly />
                        </div>
                        <div>
                            <label for="name" class="form-label">이름</label>
                            <input id="name" name = "name" class="form-control" type="text" value="${user.name}" readonly />
                        </div>
                         <div>
                            <label for="password" class="form-label">비밀번호</label>
                            <input id="password" name = "password" class="form-control" type="text" value="${user.password}" required />
                        </div>
                        <div>
                            <label for="passwordcheck" class="form-label">비밀번호확인</label>
                            <input id="passwordcheck" class="form-control" type="password" required  />
                        </div>
                        <div>
                            <label for="email" class="form-label">이메일</label>
                            <input id="email" name = "email" class="form-control" type="text" value="${user.email}" required />
                        </div>
                        <div>
                            <label for="points" class="form-label">포인트</label>
                            <input id="points" name = "points" class="form-control" type="number" value="${user.points}" readonly />
                        </div>
                        <button id="btndelete" class="btn btn-outline-danger">삭제</button>
                        <button id="btnupdate" class="btn btn-outline-success">수정</button>
                    </form>
                </div>
            </div>

        </main>

    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
    <c:url var="delete" value="/user/delete"></c:url>
    <c:url var="update" value="/user/update"></c:url>
    <script>
                    // id = postForm인 html 요소를 찾음
                    const form = document.querySelector('#form');

                    // id = btndelete인 button을 찾음
                    const btndelete = document.querySelector('#btndelete');
                    const btnupdate = document.querySelector('#btnupdate');

                    // 버튼 클릭 이벤트 리스너를 등록
                    btndelete.addEventListener('click', function(event) {
                        event.preventDefault();
                        const password = document.querySelector('#password').value;
                        const passwordcheck = document.querySelector('#passwordcheck').value;
                        
                        if (password == '' || passwordcheck == '') {
                            alert('비밀번호가 확인 되어야 삭제 가능합니다.');
                            return;
                            }

                        if (password != passwordcheck){
                            alert('비밀번호가 서로 다릅니다.');
                            return;
                        }
                        
                        const check = confirm('삭제 하시겠습니까?');

                        if (check) { // 삭제 한다고 하면
                            form.action = '${delete}'; // 제출 요청 주소
                            form.method = 'post';
                            form.submit();
                        }
                    });

                    btnupdate.addEventListener('click',function(event) {
                        event.preventDefault();
                        const password = document.querySelector('#password').value;
                        const passwordcheck = document.querySelector('#passwordcheck').value;
                        const email = document.querySelector('#email').value;
                        
                        
                        
                        if (password == '' || passwordcheck == '' || email =='') {
                            alert('비밀번호 또는 메일이 비어있습니다.');
                            return;
                            }

                        if (password != passwordcheck){
                        	alert('비밀번호가 서로 다릅니다.');
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