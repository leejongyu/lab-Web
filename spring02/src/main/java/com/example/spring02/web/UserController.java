package com.example.spring02.web;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.spring02.domain.Post;
import com.example.spring02.domain.Userlist;
import com.example.spring02.dto.PostUpdatedto;
import com.example.spring02.dto.UserSigninDto;
import com.example.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/list")
    public String list(Model model) {
        List<Userlist> list = userService.read();
        
        model.addAttribute("list", list);
        
        return "/user/list";
    }
    
    @GetMapping("/create")
    public String create() {
        return "/user/create";
    }
    
    @PostMapping("/create")
    public String postcreate(String name, String password, String email) {
        
        Userlist user = Userlist.builder().name(name).password(password).email(email).build();
        
        userService.insert(user);
        
        return "redirect:/user/list";
    }

    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        
        Userlist user = userService.read(id);
        
        model.addAttribute("user",user);
        log.info("read user = {}", user);
        return "/user/detail";
    }
    
    @GetMapping("/modify")
    public String modify(Integer id, Model model) {
        Userlist user = userService.read(id);
        
        model.addAttribute("user",user);
        log.info("read user = {}", user);
        return "/user/modify";
    }
    
    @PostMapping("/delete")
    public String delete(Integer id) {
        
        log.info("read user = {}", id);
        
        userService.delete(id);
        
        return "redirect:/user/list";
    }
    
    @PostMapping("/update")
    public String update(Integer id, String password, String email, Integer points) {
        log.info("update()");
        
        Userlist user = Userlist.builder().id(id).password(password).email(email).points(points).build();
        
        userService.update(user);
        
        return "redirect:/user/detail?id="+user.getId();
    }
    
    @GetMapping("/signin")
    public String signin() {
        
        return "/user/signin";
    }
    
    @PostMapping("/signin")
    public String signin(HttpServletRequest request, UserSigninDto dto) {
        
        Userlist user = userService.signin(dto.toEntity());
        
        log.info("user = {}", user);
        if (user == null) {
            return "redirect:/user/signin";
        }
        
        HttpSession session = request.getSession();
        
        session.setAttribute("signInUser", user.getName());
        
        log.info("session? = {}", session);
        return "redirect:/post/list";
    }
}
