package edu.web.jsp01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */

// @WebServlet 없이 만드는 방법
/*
 * Servlet을 설정하는 방법
 *  > 2가지 방법 중 1가지 방법만 사용해야함.
 * 1. 배포관리자 (deployment descriptor, web.xml)에서 설정 (servlet mapping)
 * 2. @WebServlet 애너테이션
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        // 생성자 생략 가능
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("secondServlet.doGet() 호출");
	    
	    response.setContentType("text/html; charset=UTF-8");
	    
        response.getWriter()
        .append("<!doctype html>")
        .append("<html>")
        .append("   <head>")
        .append("       <meta charset='UTF-8'>")
        .append("       <title>Servlet</title>")
        .append("   </head>")
        .append("   <body>")
        .append("       <h1>두번째 서블릿(Servlet...!)</h1>")
        .append("<h2>")
        .append("<a href='/jsp01'>메인페이지로 이동</a>")
        .append("</h2>")
        .append("   </body>")
        .append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
