<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTACT</title>
<style>
div {
    text-align: center;
    padding: 8px;
    margin: auto;
    justify-content: center;
    padding: 8px;
}

h1 {
    text-align: center;
}

label {
    padding: 8px;
    margin: auto;
}

textarea {
    color : black;
}
</style>

</head>
<body>

    <h1>입력된 메모 페이지</h1>

    <div>
        <label>번호 </label> <input type="number" value="${post.id}" readonly /> <br />
        <label>제목</label> <input type="text" value="${post.title}" readonly /><br />
        <label>본문</label> <textarea rows="20" cols="20" readonly>${post.content} </textarea><br /> 
        <label>작성시간</label> <input type="datetime-local" value="${post.createTime}" readonly /><br />
    </div>


</body>
</html>