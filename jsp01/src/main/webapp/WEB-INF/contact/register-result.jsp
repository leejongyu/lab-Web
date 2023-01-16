<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTACT</title>
</head>
<body>

    <h1>연락처 등록 결과 페이지</h1>

    <div>
        <label>Name</label> <input type="text" value="${contact.name}" />
        <label>Number</label> <input type="tel" value="${contact.number}" />
        <label>Mail</label> <input type="email" value="${contact.mail}" />
    </div>


</body>
</html>