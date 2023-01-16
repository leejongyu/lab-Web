package com.example.spring02.dto;

import com.example.spring02.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostUpdatedto {

    private Integer id;
    private String title;
    private String content;

    
    public Post toEntity() {
    return Post.builder().id(id).title(title).content(content).build();
    }
}
