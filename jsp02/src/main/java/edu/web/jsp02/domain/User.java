package edu.web.jsp02.domain;

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
public class User {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer points;
    
}
