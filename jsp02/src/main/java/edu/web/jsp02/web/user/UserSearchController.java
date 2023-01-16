package edu.web.jsp02.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;

/**
 * Servlet implementation class UserSearchController
 */
@WebServlet(name = "userSearchController", urlPatterns = { "/user/search" })
public class UserSearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchController() {

        userService = UserServiceImpl.getinstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        
        List<User> list = userService.search(type,keyword);
        
        request.setAttribute("users", list);
        
        request.getRequestDispatcher("/WEB-INF/user/list.jsp").forward(request, response);
        
    }

}
