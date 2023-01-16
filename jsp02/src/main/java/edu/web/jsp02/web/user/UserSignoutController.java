package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSignoutController
 */
@WebServlet(name = "userSignoutController", urlPatterns = { "/user/signout" })
public class UserSignoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 로그아웃 :
	    // (1) 세션에 저장된 속성(attribute)를 제거
	    HttpSession session = request.getSession();
	    session.removeAttribute("signInUser");
	    
	    // (2) 세션 객체 무효화
	    session.invalidate();
	    
	    
	    // 로그아웃 이후에는 로그인 페이지로 이동
	    response.sendRedirect("/jsp02/user/signin");
	}

}
