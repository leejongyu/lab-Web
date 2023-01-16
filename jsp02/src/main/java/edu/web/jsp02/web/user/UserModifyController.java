package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserUpdateDto;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet(name = "userModifyController", urlPatterns = { "/user/modify" })
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyController() {
        userService = UserServiceImpl.getinstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    
	    User user = userService.read(id);
	    
	    request.setAttribute("user", user);
	    
	    request.getRequestDispatcher("/WEB-INF/user/modify.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    Integer points = Integer.valueOf(request.getParameter("points"));
	    
	    UserUpdateDto dto = new UserUpdateDto(id, password, email, points);
	    
	    int result = userService.update(dto);
	    
	    response.sendRedirect("/jsp02/user");
	
	}

}
