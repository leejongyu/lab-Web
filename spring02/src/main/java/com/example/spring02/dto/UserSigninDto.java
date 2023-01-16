package com.example.spring02.dto;

import com.example.spring02.domain.Userlist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSigninDto {
    private String name;
    private String password;
    
    
    public Userlist toEntity() {
        
        return Userlist.builder().name(name).password(password).build();
    }
}
