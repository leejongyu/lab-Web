package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.Userlist;
import com.example.spring02.dto.PostUpdatedto;
import com.example.spring02.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    
    public List<Userlist> read(){
        
        return userMapper.selectAllUser();
    }

    public Userlist read(Integer id) {
        log.info("read id ={}",id);
        return userMapper.selectUser(id);
    }

    public int delete(Integer id) {
        log.info("delete id = {}",id);
        return userMapper.deleteUser(id);
    }


    public int update(Userlist user) {
        log.info("update() user ={}",user);
        return userMapper.updateUser(user);
    }

    public int insert(Userlist user) {
        log.info("insert user = {}", user);
        return userMapper.insertUser(user);
    }

    public Userlist signin(Userlist entity) {
        log.info("name = {}", entity);
        return userMapper.signCheck(entity);
    }
    
    
}
