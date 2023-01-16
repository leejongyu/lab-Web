package com.example.spring02.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Post {

    // FIELD 이름들은 DB 테이블의 COLUMN 이름과 동일하게 생성.
    // > mybatis에서 SQL문장(stmt)의 바인딩 파라미터들을 설정할 때 테이블의 컬럼 이름들을 사용해서 설정하기 때문에
    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime created_time;
    private LocalDateTime modified_time;

}