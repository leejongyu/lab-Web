package com.example.spring02.domain;

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
public class Userlist {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer points;

}
