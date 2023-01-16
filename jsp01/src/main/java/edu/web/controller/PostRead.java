package edu.web.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Contact;
import edu.web.jsp01.domain.Post;

/**
 * Servlet implementation class PostRead
 */
@WebServlet(name = "postRead", urlPatterns = { "/post/read" })
public class PostRead extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostRead() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/post/register.jsp").forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime createTime = LocalDateTime.parse(request.getParameter("createTime"));
        
        Post post = new Post(id, title, content, createTime);
        
        ArrayList<Post> list = new ArrayList<>();
        
        list.add(post);
        
        request.setAttribute("list", list);
        
        request.getRequestDispatcher("/WEB-INF/post/post-read.jsp").forward(request, response);
        
    }

}
