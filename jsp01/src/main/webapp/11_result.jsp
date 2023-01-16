<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% // JSP expression을 이용
// 한글을 처리
request.setCharacterEncoding("UTF-8");

String username = request.getParameter("id");

String color = request.getParameter("color");

String colorValue = "";

if (color.equals("r")) {
    colorValue = "red";
} else if (color.equals("g")) {
    colorValue = "green";
} else if (color.equals("b")) {
    colorValue = "blue";
} else {
    colorValue = "black";
} 
%>

<%--JSTL을 사용한 Java의 if 문 대체 --%>
<c:set var = "colorvalue2" value = "black"></c:set>
<c:if test="${ param.color == 'r' }">
   <c:set var="colorvalue2" value="red"></c:set>
</c:if>
<c:if test="${ param.color == 'g' }">
   <c:set var="colorvalue2" value="green"></c:set>
</c:if>
<c:if test="${ param.color == 'b' }">
   <c:set var="colorvalue2" value="blue"></c:set>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style>
h2 {
    color: <%=colorValue%>;
    font-weight: normal;
}

span {
    color : ${colorvalue2};
    font-weight:bold;    
}
</style>
</head>
<body>

    <h1>결과 페이지</h1>
    <h2>JSP Expression : <%=username%></h2>
    <h2>EL : <span>${param.id}</span></h2>

    
</body>
</html>