package edu.web.jsp02.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.web.jsp02.domain.Post;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchTest {

    
   private PostDao postDao = PostDaoImpl.getinstance();
   
   @Test
   public void test() {
       
      List<Post> list = postDao.selectByKeyword("t", "수");
      
      for (Post p : list) {
          Assertions.assertTrue(p.getTitle().toLowerCase().contains("수"));
          // -> argument가 true이면 단위테스트 성공, false이면 단위 테스트 실패.
          log.info(p.toString());
      }
       
      list = postDao.selectByKeyword("c", "다");
      
      for (Post p : list) {
          Assertions.assertTrue(p.getContent().toLowerCase().contains("다"));
          // -> argument가 true이면 단위테스트 성공, false이면 단위 테스트 실패.
          log.info(p.toString());
          
      }
      
      list = postDao.selectByKeyword("tc", "정");
      
      for (Post p : list) {
          Assertions.assertTrue(p.getContent().toLowerCase().contains("정") || p.getTitle().toLowerCase().contains("정"));
          // -> argument가 true이면 단위테스트 성공, false이면 단위 테스트 실패.
          log.info(p.toString());
      }
      
      list = postDao.selectByKeyword("a", "1");
      
      for (Post p : list) {
          Assertions.assertTrue(p.getAuthor().toLowerCase().contains("1"));
          log.info(p.toString());
      }
      
   }
    
}
