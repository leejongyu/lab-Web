package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserCreateDto;
import edu.web.jsp02.dto.UserUpdateDto;

public interface UserService {

    public List<User> read(); // 유저 전체 목록 읽어오기
    
    public int create(UserCreateDto dto); // 유저 생성
    
    public User read(Integer id); // 해당 유저의 정보 보기
    
    public int delete(Integer id); // 유저 정보 삭제
    
    public int update(UserUpdateDto dto); // 유저 정보 업데이트

    public List<User> search(String type, String keyword);

    public User signIn(String name, String password);
}
