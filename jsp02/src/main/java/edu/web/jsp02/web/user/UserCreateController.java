package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.UserCreateDto;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserCreateController
 */
@Slf4j
@WebServlet(name = "userCreateController", urlPatterns = { "/user/create" })
public class UserCreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateController() {
        userService = UserServiceImpl.getinstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/user/create.jsp").forward(request, response);

    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        UserCreateDto dto = new UserCreateDto(name, password, email);
        
        int result = userService.create(dto);
        
        if (result == 1) {

            response.sendRedirect("/jsp02/user/signin"); // 로그인 페이지로 이동   
        } else {
            response.sendRedirect("/jsp02/user/create");
        }
        
        
	}

}
