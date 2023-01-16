package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.dto.PostUpdatedto;
import com.example.spring02.mapper.PostMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service // @Service + applicationContext.xml : 스프링 컨테이너에 서비스 컴포넌트로 등록.
// -> 필요한 곳(컨트롤러 객체 등)에 service 컴포넌트를 주입할 수 있음.
public class PostService {

    // 의존성 주입 :
    // (1) 필드에 의한 의존성 주입 : @Autowired
    // @Autowired private PostMapper postMapper;

    // (2) 생성자에 의한 의존성 주입 : final 필드 + @RequiredArgsConstructor 생성자

    // 생성자에 의한 의존성 주입.
    private final PostMapper postMapper;

    public List<Post> read() {
        return postMapper.selectOrderByIdDesc();
    }

    public Post detail(Integer id) {
        return postMapper.selectById(id);
    }

    public int delete(Integer id) {
        return postMapper.deleteById(id);

    }

    public int update(Post post) {
        return postMapper.updateById(post);
    }

    public int insert(Post post) {
       
        return postMapper.insert(post);
    }

    public int tcreate(PostCreateDto dto) {

        return postMapper.insert(dto.toEntity());
    }

    public Post read(Integer id) {
        
        return postMapper.selectById(id);
    }

    public int tupdate(PostUpdatedto dto) {
        log.info("update()");
        
        return postMapper.updateById(dto.toEntity());
        
    }

    public List<Post> search(PostSearchDto dto) {
        log.info("search dto = {}", dto);
        
        dto.setKeyword("%" + dto.getKeyword().toLowerCase() + "%");
        
        return postMapper.search(dto);
    }
    
    


}
