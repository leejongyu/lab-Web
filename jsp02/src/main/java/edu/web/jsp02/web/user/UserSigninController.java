package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserSigninController
 */
@Slf4j
@WebServlet(name = "userSigninController", urlPatterns = { "/user/signin" })
public class UserSigninController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSigninController() {
        userService = UserServiceImpl.getinstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("do get");

        request.getRequestDispatcher("/WEB-INF/user/signin.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("do post");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = userService.signIn(name, password);

        if (user == null) { // 로그인 실패

            response.sendRedirect("/jsp02/user/signin");

            return; // doPost 메서드 종료
        }

        // 로그인 실패가 아닌 경우 = 로그인 성공시
        // 1) 세선(session)에 로그인 정보 저장. 
        
        HttpSession session = request.getSession();
        // 로그인 유저의 아이디를 세션에 저장
        session.setAttribute("signInUser", user.getName());
        // EL scope: pageScore > requestScope > sessionScope > applicationScope
        
        
        // 2) 다음 페이지로 이동
        response.sendRedirect("/jsp02/post"); //post 목록 페이지로 이동
        
    }

}
