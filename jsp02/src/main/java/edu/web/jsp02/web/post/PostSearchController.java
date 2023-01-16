package edu.web.jsp02.web.post;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class PostSearchController
 */
@Slf4j
@WebServlet(name = "postSearchController", urlPatterns = { "/post/search" })
public class PostSearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PostService postService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSearchController() {

        postService = PostServiceImpl.getinstance();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        log.info(type);
        String keyword = request.getParameter("keyword");
        log.info(keyword);

        List<Post> list = postService.search(type, keyword);
        
        request.setAttribute("posts", list);
        request.setAttribute("searchPage", true);
        
        request.getRequestDispatcher("/WEB-INF/post/list.jsp").forward(request, response);
    }


}
