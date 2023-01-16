<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

    <h1>EL (Expression Language)</h1>
    <%--
         ${ 표현식 (expression) } 
         
    1) 사용 불가능한 곳
     > 지시문(directive, <%@ ... %>) 안에서 사용할 수 없음.
     > 선언문(declarationm <%! ... %>) 안에서 사용할 수 없음.
     > 스크립트릿(scriptlet <% %>) 안에서 사용할 수 없음.
     > 식(expression <%= %> 안에서 사용할 수 없음.    
     그 이외의 모든 곳에서 사용 가능. 
     
    2) 사용 가능한 곳
     > HTML element의 컨텐트(시작, 끝 태그로 이루어진 것들)로 사용 가능 - h1, h2 .... , a, ul, li, tr, td ....
     > HTML 태그의 속성(attribute) 값으로 사용 가능. ex) <img src =${ ? } /> ...
     > CSS 스타일의 프로퍼티 값을 설정할 때 사용 가능
     > JavaScript 코드와 함께 사용 가능.
     
    
    --%>


    <%
    int a = 1 + 2;
    out.print(a);
    %>
    <br />
    <%=1 + 3%>
    <br /> ${1+4}
    <br />


</body>
</html>