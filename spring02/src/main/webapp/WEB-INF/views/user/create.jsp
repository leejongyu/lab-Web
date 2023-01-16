<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring 2</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
</style>
</head>
<body>

    <nav>
        <ul class="nav my-4 bg-light">
            <li class="nav-item"><c:url var="list" value="/user/list"></c:url>
                <a class="nav-link" href="${list}">유저목록보기</a></li>
            
        </ul>
    </nav>

    <main>
        <div class = "card m-4">
            <form class = "m-4" method="post">
                <div class= "my-2">
                    <label for = "name" class= "form-label">이름</label> <input type="text" name="name" id = "name" class = "form-control" required autofocus />
                </div>
                <div class= "my-2">
                    <label for = "password" class= "form-label">비밀번호</label> <input type="password" name="password" id = "password" class = "form-control" required />
                </div>
                <div class= "my-2">
                    <label for = "passwordcheck" class= "form-label">비밀번호 확인</label> <input type="password" name="passwordcheck" id = "passwordcheck" class = "form-control" required />
                </div>
                <div class= "my-2">
                    <label for = "email" class= "form-label">이메일</label> <input type="email" name="email" id = "email" class = "form-control" required />
                </div>
                <div class= "my-2">
                    <input id = "submit" type="submit" class = "form-control btn btn-outline-success" value="회원가입" />
                </div>
    
    
            </form>
        </div>  

    </main>
    
    
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<script>
const submit = document.querySelector('#submit');

submit.addEventListener('click', function(event){

	 const name = document.querySelector('#name').value;
     const password = document.querySelector('#password').value;
     const passwordcheck = document.querySelector('#passwordcheck').value;
     const email = document.querySelector('#email').value;
     
     if (name == '' || password == '' || passwordcheck == '' || email == '') {
         alert('입력되지 않은 칸이 있습니다.');
         return;
         }

     if (password != passwordcheck){
         alert('비밀번호가 서로 다릅니다.');
         return;
     }
     
	
});

</script>

</body>
</html>