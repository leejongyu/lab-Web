package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.Userlist;
import com.example.spring02.dto.PostUpdatedto;

public interface UserMapper {

    
    List<Userlist> selectAllUser();
    
    int insertUser(Userlist entity);
    
    int updateUser(Userlist entity);
    
    int deleteUser(Integer id);
    
    Userlist selectUser(Integer id);

    Userlist signCheck(Userlist entity);

    
}
