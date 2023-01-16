<%@page import="edu.web.jsp01.domain.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 버그 </title>
</head>
<body>

    <h1>&lt;c:foreach&gt;</h1>
    
    <%
    // HTML 리스트 아이템으로 사용할 더미 데이터
    String[] sites = {"Youtube", "NAVER", "instagram","daum"};
    
    // EL에서는 Java의 지역변수를 직접 접근할 수 없기 때문에 pageContext, request, session, application 속성으로 추가
    
    pageContext.setAttribute("sites", sites);
    %>
    
    <h2>scriptlet</h2>
    
    <ul>
    
        <% for (String s : sites) { %>
        <li> <%= s %> </li>
        
        <% } %>
    </ul>
    
    
    <h2>JSTL &amp; EL</h2>
    
    <ul>
        <c:forEach var="s" items="${sites}">
            <li>  ${s} </li>
        </c:forEach>
    </ul>
    
    
    <h2> JSP를 이용한 table </h2>
    
    <%
    ArrayList<Contact> list = new ArrayList<Contact>();
    for (int i = 0; i < 5; i++){
        Contact c = new Contact("이름" + i, "전화번호"+i,"메일주소"+i);
         list.add(c);
    }
    
    // 바깥 el 구문에서 사용하기 위해서
    pageContext.setAttribute("contacts", list);
    %>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            </tr>
        </thead>
        <tbody>
            <% for (Contact c: list) { %>
                <tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getNumber() %></td>
                    <td><%= c.getMail() %></td>    
                </tr>
                
            <% } %>
        </tbody>
    </table>
    
        <h2> JSTL - EL 이용한 table </h2>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${contacts}">
                <tr>
                <td>${c.name}</td>
                <td>${c.number}</td>
                <td>${c.mail}</td> 
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>