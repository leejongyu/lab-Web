package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;

/**
 * Servlet implementation class UserDeleteController
 */
@WebServlet(name = "userDeleteController", urlPatterns = { "/user/delete" })
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        userService = UserServiceImpl.getinstance();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        
        int result = userService.delete(id);
        
        response.sendRedirect("/jsp02/user");
        
    }
}
