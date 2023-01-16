<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
/* CSS 주석 */
</style>

</head>
<body>

    <%
    /* Java 블록 주석 */
    System.out.println("01_intro.jsp");
    %>

    <h1>첫번째 JSP</h1>
    <%
    LocalDateTime now = LocalDateTime.now();
    %>

    <h2>
        서버시간 :
        <%=now.toString()%>
    </h2>
    <!-- HTML/XML 주석 -->
    
    
    <script>
	/* JavaScript 블록 주석 */
	// JavaScript 인라인 주석
	</script>

    <%-- JSP 주석 --%>
    <%-- Serlvet/ JSP 동작 방식
    
    Servlet : Servert + Applet (웹 서버에서 실행되는, 요청을 처리하는 작은 프로그램)
     - 웹 서버가 클라이언트로부터 요청을 받았을 때 동적으로 html 문서를 생성하기 위한 프로그램 
     - Java class로 작성.
     - Servlet의 생성, Servlet 객체의 메서드 호출은 WAS가 담당.
      * 최초 요청 -> Servlet 객체 생성 -> 요청 방식에 따라  doGet()/ doPost()와 같은 메서드 호출 -> 응답
      * 최초 요청이 아닌 요청 -> 생성된 Servlet 객체에서 doGet()/doPost() 메서드를 호출 -> 응답
    
    
    JSP : Java Server Page
     - Servlet은 순수한 Java 코드이기 때문에 HTML을 작성하는 것이 힘듦
     - HTML형식의 문서에서 Java 코드들이 실행될 수 있도록 만든 Server-side 기술.
     - JSP의 동작원리 : jsp -> java -> class(컴파일) -> 객체 생성 -> 메서드 호출
      * 최초 요청 -> jsp를 Servlet class(java)로 변환 -> 컴파일(class) -> 객체 생성 -> doGet()/ doPost() 메서드 호출 
                                       JSP (Java file) -  WAS (compile) - 
      * 최초 요청이 아닌 요청 -> 생성된 Servlet 객체에서 메서드를 호출 -> 응답
    
    
    JSP 구성요소(태그)
     1. 지시자 (directive) : <%@ ... %>
        <%@ page ... %> <%@ include ... > <%@ taglib ... > ...
        JSP 설정.
        
     2. 선언문 (declaration): <%! ... %>
        JSP가 Java 파일로 변환될 때, 필드(멤버 변수)와 메서드 정의하는 코드.
        
     3. 스크립트릿 (scriptlet) : <% ... %>
        JSP가 Java로 변환될 때, _jspServic(request, response) 메서드 안에 포함되는 코드.
        지역 변수 선언. 메서드 호출. 조건문. 반복문 .... 
        Java 입력방식에 맞게 세미콜론 사용
        
     4. 식, 표현식(expression) : <%= ... %>
        JSP가 Java로 변환될 때, out.print() 메서드의 argument로 전달되는 값.
        HTML에 바로 삽입되는 값.
        세미콜론 사용 x
        
     5. 주석(comment) : <%-- --%>


    <%-- Declaration선언문 --%>
    
    
    <%! 
    // 멤버변수 선언
    private final String username = "김뚤딸";
    
    // getter 메서드
    public String getUsername() {
        return this.username;
    }
    
    %>

    <h3>Username : <%= getUsername() %></h3>


</body>
</html>