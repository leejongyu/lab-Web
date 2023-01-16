<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JYP</title>
</head>
<body>


    <h1>JSP 내장 객체 VS EL 내장 객체</h1>

    <%--
    상태 정보 유지 : 속성(값) 추가, 저장된 속성값을 읽음.
    
    1) JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들 : 
        * pageContext : JSP 페이지가 유지되는 동안 사용. 
        * request : 요청 객체가 유지되는 동안 사용.
        * session : 세션이 유지되는 동안 사용
        * application : 웹 애플리케이션이 동작 중에 사용
        * 상태정보 유지되는 시간 : pageContext < request < session < application
    
    2) EL에서 상태 정보들을 유지하기 위해서 사용하는 객체들
        * pageScope : JSP 페이지가 유지되는 동안 사용. 
        * requestScope : 요청 객체가 유지되는 동안 사용.
        * sessionScope : 세션이 유지되는 동안 사용
        * applicationScope : 웹 애플리케이션이 동작 중에 사용
         
        EL ${ 속성이름 } 의 동작원리 :
         * 속성이름을 찾을 때 : ${pageScope.attr} => ${requestScope.attr} => ${sessionScope.attr} => ${applicationScope.attr}
     --%>

    <h2>JYP</h2>
    <%
    pageContext.setAttribute("number1", 1);
    request.setAttribute("number2", 2);
    session.setAttribute("number3", 3);
    application.setAttribute("number4", 4);
    %>
    
    pageContext 속성 : <%= pageContext.getAttribute("number1") %>
    <br/>
    request 속성 : <%= request.getAttribute("number2") %>
    <br/>
    session 속성 : <%= session.getAttribute("number3") %>
    <br/>
    apllication 속성 : <%= application.getAttribute("number4") %>
    <br/>

      <h2>EL</h2>
    pageScope 속성 : ${number1} 
    <br/>
    requestScope 속성 : ${number2}
    <br/> 
    sessionScope 속성 : ${number3} 
    <br/>
    applicationScope 속성 : ${number4}
    <br/>

</body>
</html>