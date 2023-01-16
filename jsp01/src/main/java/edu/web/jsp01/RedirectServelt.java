package edu.web.jsp01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServelt
 */
@WebServlet(name = "redirectServelt", urlPatterns = { "/ex5" })
public class RedirectServelt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("redirectServelt.doGet() 호추루루룰");
        
        // 클라이언트에서 온 요청을 "redirect" 방식으로 페이지 이동.
        // 최초 요청의 request, response 객체가 유지되지 않음.
        // 최초 요청의 요청 주소가 이동하는 페이지의 주소로 바뀜.
        // 같은 웹 서버 뿐만 아니라, 외부 서버의 페이지로도 이동이 가능.
        
        // response.sendRedirect("http://naver.com");
        response.sendRedirect("example.jsp");
    }

}
