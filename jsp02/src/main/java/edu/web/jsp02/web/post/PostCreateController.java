package edu.web.jsp02.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostCreateController
 */
@Slf4j
@WebServlet(name = "postCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCreateController() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("do get");
        
        
        // 포스트 작성 view로 이동
        request.getRequestDispatcher("/WEB-INF/post/create.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("do post");
        
        // 요청 파라미터 분석: title, content, author 값을 찾음.
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        
        // PostCreateDto 타입 객체 생성
        PostCreateDto dto = new PostCreateDto(title, content, author);
        
                
        // postService.create(dto) 메서드 호출 > postDao 호출 --> DB에 저장
        PostServiceImpl dao = PostServiceImpl.getinstance();
        dao.create(dto); // WEB에 등록된 정보를 dto로 변환해서 argument로 service layer에 전달
        
        // 포스트 목록 페이지 이동 (redirect)
        response.sendRedirect("/jsp02/post");
    
        // PRG(post - Redirect - Get) 패턴
    }

}
