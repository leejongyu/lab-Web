package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Contact;

/**
 * Servlet implementation class ContactRegisterController
 */
@WebServlet(name = "contactRegisterController", urlPatterns = {"/contact/register"})
public class ContactRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactRegisterController() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Contact Register Controller - doGet() 호출");	
	
	// View(JSP 페이지)로 "Forward" 이동
	request.getRequestDispatcher("/WEB-INF/contact/register.jsp").forward(request, response);
	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Contact Register Controller - doPost() 호출"); 
    
    request.setCharacterEncoding("UTF-8");
    
    // 입력된 정보를 객체로 변환
    String name = request.getParameter("name");
    String number = request.getParameter("number");
    String email = request.getParameter("mail");
    
    Contact contact = new Contact(name, number, email);
    
    // 연락처 정보를 View(JSP)에 전달
    
    request.setAttribute("contact", contact);
    
    // View(JSP)로 이동
    
    request.getRequestDispatcher("/WEB-INF/contact/register-result.jsp").forward(request, response);
    
	}

}
