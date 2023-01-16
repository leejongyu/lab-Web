<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>

    <h1>JSTL &lt;c:url&gt;</h1>

    <ul>
        <li>
            <a href="12_result.jsp?color=r&id=ad&min">클릭</a>
        </li>
        <li>
            <c:url var="url01" value="12_result.jsp"> <%-- 요청 URL --%>
             <c:param name="color" value="r"></c:param> <%-- 요청 파라미터 --%>
             <c:param name="id" value="ad&min"></c:param>
            </c:url>
            <a href="${url01}">클릭 클릭</a>
        </li>
    </ul>

</body>
</html>