package edu.web.jsp01;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name = "firstServlet", urlPatterns = { "/ex1" })
// > 처리하는 요청 주소(request URL)
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {

    }

    @Override
    // -> GET 방식의 요청일 때 WAS가 호출하는 메서드.
    // -> 파라미터 request : 클라이언트(브라우저)가 보낸 요청(request))에 대한 정보를 가지고 있는 객체.
    // -> 파라미터 response : WAS가 클라이언트로 보낼 응답(response)을 작성하기 위한 기능들을 가지고 있는 객체.
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response의 한글이 깨지지 않도록 하기 위해서.
        // 반드시 response.getWriter() 메소드 호출 전에 해야함.
        response.setContentType("text/html; charset=UTF-8");

        LocalDateTime now = LocalDateTime.now();

        PrintWriter writer = response.getWriter();

        // 응답으로 보낼 
        writer.append("<!doctype html>").append("<html>")
        .append("   <head>")
        .append("       <meta charset='UTF-8'>")
        .append("       <title>Servlet</title>")
        .append("   </head>")
        .append("   <body>")
        .append("       <h1>첫번째 서블릿(Servlet...!)</h1>")
        .append("<h2>")
        .append(now.toString())
        .append("</h2>")
        .append("   </body>")
        .append("</html>");
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    // -> POST 방식의 요청일 때 WAS가 호출하는 메서드
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
