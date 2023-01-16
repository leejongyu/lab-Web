package edu.web.jsp02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostUpdateDto {

   private Integer id;
   private String title;
   private String content;
    
}
