package edu.web.jsp02.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.web.jsp02.domain.Post;

@TestMethodOrder(OrderAnnotation.class) // 테스트 메서드들의 실행 순서를 애너테이션으로 지정.
public class PostDaoTest {
    
    private static final Logger log = LoggerFactory.getLogger(PostDaoTest.class);
    
    private PostDao postDao = PostDaoImpl.getinstance();
    
    
    @Test
    @Order(1)
    public void testInsert() {
        
        // DB 테이블에 insert 할 데이터 (제목, 내용, 작성)
        Post entity = Post.builder().title("DAO TEST...").content("TTEESSTT").author("ADMIN").build();
        // Data Source를 사용한 DB insert 실행
        int result = postDao.insert(entity);
        // DB insert 실행 결과 == 1
        Assertions.assertEquals(1, result);       
    }
    
    @Test
    @Order(2)
    public void testSelect() {
        
        List<Post> list = postDao.select();
        
        for (Post p : list) {

            log.info(p.toString());
        }
        
        
    }
    

}
