package edu.web.jsp01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/ex3")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("userInfoServlet.doGAet()");
        
        response.setContentType("text/html; charset=UTF-8");
        
        response.getWriter()
        .append("<!doctype html>")
        .append("<html>")
        .append("   <head>")
        .append("       <meta charset='UTF-8'>")
        .append("       <title>Servlet</title>")
        .append("   </head>")
        .append("   <body>")
        .append("       <h1>사용자 정보 전송</h1>")
        .append("<form method = 'post'>")
        .append("<input type='text' name='username' />")
        .append("<input type='submit' value = '제출' />")
        .append("</form>")
        .append("   </body>")
        .append("</html>");
    }
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("userInfoServlet.doPosst()");
        // 요청객체의 처리를 위하여 char encoding
        request.setCharacterEncoding("UTF-8");
        
        // 클라이언트가 요청으로 보낸 request 파라미터 값을 읽음
        String username = request.getParameter("username"); // input된  username이라는 이름의 text를 읽기 위해서
        System.out.println(username);
        
        // 서버에서 클라이언트로 보내는 응답을 작성.
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("<!doctype html>")
        .append("<html>")
        .append("   <head>")
        .append("       <meta charset='UTF-8'>")
        .append("       <title>Servlet</title>")
        .append("   </head>")
        .append("   <body>")
        .append("       <h1> 안녕하세요 ," + username
                + " !!! </h1>")
        .append("   </body>")
        .append("</html>");
    }

}
