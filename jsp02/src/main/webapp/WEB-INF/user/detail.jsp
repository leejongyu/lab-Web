<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
main{
text-align: center;
}
</style>
<title>유저 상세보기</title>
</head>
<body>
<div>
        <h1>유저 상세 페이지</h1>

        <nav>
            <ul>
                <li>
                <c:url var = "main" value="/"></c:url>
                <a href="${main}">메인 페이지</a></li>
                <li>
                <c:url var = "list" value="/user"></c:url>
                <a href="${list}">전체 유저 보기</a></li>
                <li>
                <c:url var = "modify" value="/user/modify">
                    <c:param name="id" value="${user.id}"></c:param>
                </c:url>
                <a href="${modify}">회원정보 수정하기</a></li>
            </ul>
        </nav>

        <main>
            <form>
            <div>
                <label for ="id">고유번호</label> <input id ="id" type="number" value="${user.id}" readonly /> <br />
            </div>
            <div>
                <label for ="name">이름</label> <input id ="name" type="text" value="${user.name}" readonly /><br />
            </div>
            <div>
                <label for ="password">비밀번호</label> <input id ="password" type="text" value="${user.password}" readonly /><br />
            </div>
            <div>
                <label for ="email">메일주소</label> <input id ="email" type="email" value="${user.email}" readonly /><br />
            </div>
            <div>
                <label for ="points">포인트</label> <input id ="points" type="number" value="${user.points}" readonly /><br />
            </div>
            </form>
        </main>
    </div>
</body>
</html>