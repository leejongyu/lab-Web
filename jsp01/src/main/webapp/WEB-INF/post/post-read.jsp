<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST-READ</title>
<style>
td {
border: 1px solid gray;
}
</style>
</head>
<body>
<table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성시간</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="l" items="${list}">
                <tr>
                <td>${l.id}</td>
                <td>${l.title}</td>
                <td>${l.content}</td> 
                <td>${l.createTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>