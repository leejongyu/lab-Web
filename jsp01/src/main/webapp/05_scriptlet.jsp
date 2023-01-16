<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.reflect.Array"%>
<%@ page import="edu.web.jsp01.domain.Contact"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

    <h1>JSP scriptlet을 사용한 테이블 작성</h1>

    <%-- 테이블을 작성하기 위한 Contact 더미 데이터 생성 --%>

    <%
    ArrayList<Contact> list = new ArrayList<>(); // 빈 리스트 생성

    for (int i = 1; i <= 10; i++) {
        String name = "이름 : " + i;
        String number = "전화번호 : " + i;
        String mail = "메일주소 : " + i;

        Contact c = new Contact(name, number, mail);

        list.add(c);
    }
    %>

    <table>
        <caption>연락처</caption>
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            </tr>

        </thead>

        <tbody>
            <%
            for (Contact c : list) {
                out.print("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getNumber() + "</td>");
                out.println("<td>" + c.getMail() + "</td>");
                out.print("</tr>");
            }
            %>
        </tbody>
    </table>

    <table>
        <caption>연락처</caption>
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Contact c : list) {
            %>
            <tr>
                <td> <%=c.getName()%> </td>
                <td> <%=c.getNumber()%> </td>
                <td> <%=c.getMail()%> </td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>



</body>
</html>