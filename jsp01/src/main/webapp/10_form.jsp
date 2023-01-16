<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style>

div {
    text-align: center;
    border: 1px gray solid;
    margin: 8px;
    padding: 8px;
}

</style>
</head>
<body>

    <h1>Form 제출 페이지</h1>


    <form action="12_result.jsp" method="get">
        <div>
            <input type="text" name="id" placeholder="아이디 입력" autofocus required />
        </div>
        <div>
            <select name="color">
                <option value="r">붉은색</option>
                <option value="b">푸른색</option>
                <option value="g">초록색</option>
            </select>
        </div>
        <div>
            <input type="submit" value="입력" />
        </div>
    </form>



</body>
</html>