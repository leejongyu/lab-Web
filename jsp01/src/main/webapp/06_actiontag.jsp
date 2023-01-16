<%@page import="edu.web.jsp01.domain.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>JSP Action Tag</h1>

    <%--  
        scriptlet에서 사용되어지는 자바 코드들을 HTML과 비슷한 태그로 대체하기 위해서 JSP에서 표준으로 만든 태그
        <jsp:태그이름> .... </jsp:태그이름>
        
        o. <jsp:forward>
        o. <jsp:include>
        o. <jsp:useBean>
    
     --%>




    <%
    Contact contact = new Contact();

    // setter를 사용해서 필드의 값을 초기화
    contact.setName("이존규");
    contact.setNumber("010-0000-0000");
    contact.setMail("puhahahaha.co.kr");

    // 내장객체 out을 사용해서 HTML로 출력

    out.println(contact.getName() + "<br/>");
    out.println(contact.getNumber() + "<br/>");
    out.println(contact.getMail() + "<br/>");
    %>


    <h2>useBean</h2>
    <jsp:useBean id="contact2" class="edu.web.jsp01.domain.Contact"></jsp:useBean> <%-- == Contact contact2 = new Contact(); --%>
    <jsp:setProperty name="contact2" property="name" value="홍길동" /> <%-- contact2.setName("홍길동"); --%>
    <jsp:setProperty name="contact2" property="number" value="010-0000-0000" />
    <jsp:setProperty name="contact2" property="mail" value="RedGildong.co.kr" />

    <jsp:getProperty name="contact2" property="name" /> <%-- contact2.getName(); --%>
    <br/>
    <jsp:getProperty name="contact2" property="number"/>
    <br/>
    <jsp:getProperty name="contact2" property="mail"/>
    <br/>

</body>
</html>