package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserCreateDto;
import edu.web.jsp02.dto.UserUpdateDto;
import edu.web.jsp02.repository.UserDao;
import edu.web.jsp02.repository.UserDaoImpl;

public class UserServiceImpl implements UserService {

    private UserDao userdao;
    
    private static UserServiceImpl instance = null;
    
    private UserServiceImpl() {
        
        userdao = UserDaoImpl.getinstance();
    }
    
    public static UserServiceImpl getinstance() {
        
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        
        return instance;
    }
    
    @Override
    public List<User> read() {
        
        return userdao.select();
        
    }

    @Override
    public int create(UserCreateDto dto) {
        
        return userdao.insert(dto.toEntity());
    }

    @Override
    public User read(Integer id) {
        
        return userdao.selectById(id);
    }

    @Override
    public int delete(Integer id) {
        
        return userdao.delete(id);
    }

    @Override
    public int update(UserUpdateDto dto) {
        
        return userdao.update(dto.toEntity());
    }

    @Override
    public List<User> search(String type, String keyword) {
       return userdao.search(type, keyword);
    }
    
    @Override
    public User signIn(String name, String password) {
        
        User user = User.builder().name(name).password(password).build();
        
        return userdao.signCheck(user);
    }
}
