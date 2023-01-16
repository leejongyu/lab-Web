<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%
String color = request.getParameter("color");
String colorValue = "";

switch (color) {
case "r":
    colorValue = "indianred";
    break;
case "g":
    colorValue = "MediumSeaGrean";
    break;
case "b":
    colorValue = "DodgerBlue";
    break;
default:
    colorValue = "gray";
}

%>

<c:choose>
    <c:when test="${param.color == 'r'}">
        <c:set var="colorValue" value="Indianred"></c:set>
    </c:when>
    <c:when test="${param.color == 'g'}">
        <c:set var="colorValue" value="mediumseagreen"></c:set>
    </c:when>
    <c:when test="${param.color == 'b'}">
        <c:set var="colorValue" value="dodgerblue"></c:set>
    </c:when>
    <c:otherwise>
        <c:set var="colorValue" value="black"></c:set>
    </c:otherwise>
</c:choose>

<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style>
span {

    color: ${colorValue};
    font-weigth : bold ;
    
}
</style>
</head>
<body>

    <h1>JSTL &lt;c:choose&gt;</h1>
    <h2>
        username: <span>${param.id}</span>
    </h2>

    <c:choose>
        <c:when test="${param.id=='admin'}">
            <h3> 관리자 페이지 </h3>
        </c:when>
        <c:otherwise>
            <h3> 민간인 페이지 </h3>
        </c:otherwise>
    </c:choose>

</body>
</html>