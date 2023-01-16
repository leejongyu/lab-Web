<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORMATDATE</title>
</head>
<body>
    <h1>JSTL &lt;fmt:formatDate&gt;</h1>

    <c:set var="now" value="<%=new Date()%>"></c:set>
    
    <%--
    fmt:formatDate 태그는 java.sql.Date, java.spl.Timestamp, java.util.Date 타입만 지원
    (주의) java.time.LocalDate, java.time.LocalDateTime은 지원하지 않음.
     --%>
    
    
    <h2>${now}</h2> <%-- = now.toString() --%>
    
    <h2> [입력X]
        <fmt:formatDate value="${now}"/>
    </h2>
    <h2> [type = date]
        <fmt:formatDate value="${now}" type="date"/>
    </h2>
    <h2> [type = time]
        <fmt:formatDate value="${now}" type="time"/>
    </h2>
    <h2> [type = both]
        <fmt:formatDate value="${now}" type="both" />
    </h2>
    <h2> [type = both] [datestyle = full] [timestyle = full]
        <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
    </h2>
    <h2> [type = both] [datestyle = short] [timestyle = short]
        <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/>
    </h2>
    <h2> [patten= yyyy-MM-dd HH:mm]
        <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm"/>

    </h2>

</body>
</html>