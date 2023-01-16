package edu.web.jsp02.service;

import java.util.ArrayList;
import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.repository.PostDao;
import edu.web.jsp02.repository.PostDaoImpl;
import lombok.extern.slf4j.Slf4j;

// Request -> Controller -> Service -> Repository
// Service (Buisness) 계층을 담당하는 클래스

@Slf4j // Logger 객체가 생성
public class PostServiceImpl implements PostService {

    private PostDao postDao; // DB select, insert, update, delete 기능

    // singleton

    private static PostServiceImpl instance = null;

    private PostServiceImpl() {
        postDao = PostDaoImpl.getinstance();
    }

    public static PostServiceImpl getinstance() {

        if (instance == null) {
            instance = new PostServiceImpl();
        }

        return instance;
    }

    @Override
    public List<Post> read() {

        log.info("read()");

        return postDao.select();
    }

    @Override
    public int create(PostCreateDto dto) {
        log.info("create()");
        
        return postDao.insert(dto.toEntity());
    }

    @Override
    public Post read(Integer id) {
        log.info("read(id)");
        
        // PostDao 객체의 메서드를 호출해서 DB 테이블에서 id로 검색.
        return postDao.selectById(id);
    }
    
    @Override
    public int delete(Integer id) {
        log.info("delete");
        return postDao.delete(id);
    }
    
    @Override
    public int update(Integer id, String title, String content) {
        log.info("update");
        
        return postDao.update(id, title, content);
    }
    
    @Override
    public List<Post> search(String type, String keyword) {
        log.info("search type ={}, keyword ={}", type, keyword);
        
        return postDao.selectByKeyword(type, keyword);
    }

}
