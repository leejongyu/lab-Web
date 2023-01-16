package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;

public interface PostService {

    public List<Post> read(); // 포스트 전체 목록 읽어오기
    
    public int create(PostCreateDto dto); // 포스트 글 작성하기
    
    public Post read(Integer id); // 1개의 포스트 읽어오기

    public int delete(Integer id); // 해당 id의 포스트 삭제하기

    public int update(Integer id, String title, String content); // 해당 id의 포스트 내용 수정하기
    
    public List<Post> search(String type, String keyword); // 검색 서비스

}
