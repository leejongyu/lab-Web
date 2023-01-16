package edu.web.jsp02.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;

/**
 * Servlet implementation class UserDetailController
 */
@WebServlet(name = "userDetailController", urlPatterns = { "/user/detail" })
public class UserDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailController() {
        
        userService = UserServiceImpl.getinstance();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        Integer id = Integer.valueOf(request.getParameter("id"));
        
        User user = userService.read(id);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/user/detail.jsp").forward(request, response);
        
    }

}
