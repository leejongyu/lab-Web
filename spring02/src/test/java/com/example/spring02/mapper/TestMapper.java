package com.example.spring02.mapper;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring02.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class TestMapper {

    @Autowired
    private PostMapper postMapper;

    
    @Test
    public void testSelectById() {
        Post post = postMapper.selectById(17);
        Assertions.assertNotNull(post);
        log.info("selec by id = {}", post.toString());
        
    }
    
    
//    @Test
    public void testPostMapper() {

        Assertions.assertNotNull(postMapper);
        log.info("postmapper = {}", postMapper);
        
        Post post = Post.builder().title("새로운거 테스트22").content("테스트 중입니다22").author("오박사").build();
        
        int result = postMapper.insert(post);
        Assertions.assertEquals(1, result);
        
                    
        List<Post> list = postMapper.selectOrderByIdDesc();
        
        for(Post p : list) {
            log.info(p.toString());
        }
        
    }

}
