package com.example.spring02.dto;

import com.example.spring02.domain.Userlist;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserlistCreateDto {
    private String name;
    private String password;
    private String email;
    
    
    public Userlist toEntity() {
        
        return Userlist.builder().name(name).password(password).email(email).build();
    }
}
