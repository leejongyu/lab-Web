<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post register</title>

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
</style>
</head>
<body>
    <h1>메모 등록 페이지</h1>
    <form method="post">
        <div class="outer">
            <div class="inner">
                <input type="number" name="id" placeholder="번호" required autofocus /> <br />
            </div>
            <div class="inner">
                <input type="text" name="title" placeholder="제목" required /> <br />
            </div>
            <div class="inner">
                <textarea rows="20" cols="20" name="content" placeholder="내용" required></textarea> <br />
            </div>
            <div class="inner">
                <input type="datetime-local" name="createTime" required />
            </div>
            <div class="inner">
                <input type="submit" value="등록" />
            </div>
        </div>

    </form>

</body>
</html>