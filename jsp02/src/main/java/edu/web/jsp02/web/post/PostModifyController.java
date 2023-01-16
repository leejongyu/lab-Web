package edu.web.jsp02.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostModifyController
 */
@Slf4j
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PostService postService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        postService = PostServiceImpl.getinstance();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("dodo get");
	    
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    log.info("id : {}", id);
	    
	    Post post = postService.read(id);
	    log.info("post : {}", post);
	    
	    request.setAttribute("post", post);
	    
	    request.getRequestDispatcher("/WEB-INF/post/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("modify do post");
	    
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    String title = request.getParameter("title");
	    log.info(title);
	    String content = request.getParameter("content");
	    log.info(content);
	    int result = postService.update(id, title, content);
	    
	    log.info("modified post = {}", result);
	    
	    response.sendRedirect("/jsp02/post"); // 목록 페이지로 보내기
	    
	}

}
