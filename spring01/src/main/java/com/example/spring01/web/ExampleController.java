package com.example.spring01.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

// POJO (Plain Old Java Object): 평범한 자바객체
// 특정 클래스를 상속해야만 하거나, 상속 후엔 메서드들을 반드시 override해야만 하는 클래스가 아님.

@Slf4j
@Controller // 컴포넌트 애너테이션 중 하나. 웹 요청을 처리하는 Controller 계층의 컴포넌트.
// -> @Controller 애너테이션 + servlet-context.xml 설정 <context:component-scan>
// -> 스프링에서 객체를 생성해서 메모리에 로딩하고 관리.
public class ExampleController {

    
    @GetMapping("/")
    public String home() {
      log.info("home");
      
      return "index"; // (1)
    }
 
    
    @GetMapping("/ex1")
    public void example1() {
      log.info("ex1"); // (2)
    }
    
    
    //View Resolver (뷰를 찾는 객체)가 view(JSP file)을 찾는 방법:
    // (1) Controller 메서드가 문자열을 리턴하면, 그 문자열이 파일의 이름 (/WEB-INF/views/문자열.jsp)
    // (2) Controller 메서드의 리턴 타입이 void인 경우, 요청 주소 이름이 view의 이름이 됨.    
    
    
    @GetMapping("/ex2")
    public void example2(String name, int age, Model model) {
        // 컨트롤러 메서드를 선언할 때 파라미터의 이름을 요청 파라미터 이름과 같네 선언하면,
        // DispatcherServlet이 컨트롤러 메서드를 호출하면서 요청 파라미터의 값들을 argument로 전달해줌.
            
        log.info("ex2");
        
        // Model 타립 객체 : 컨트롤러에서 뷰로 전달할 데이터가 있을 때 사용.
        // -> Model의 속성(attribute) 이름은 JSP에서 EL로 사용할 수 있음.
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
    }
    
    @PostMapping("/ex3")
    public String exmaple3(@RequestParam(name = "name") String user, // (1)
            @RequestParam(defaultValue = "0") int age ,  // (2)
            Model model) {
        // 컨트롤러 메서드를 선언할 때 Requestparam 애너테이션을 사용
        // (1) 메서드 파라미터와 요청 파라미터 이름이 다를 때, name 속성을 설정.
        // (2) 요청 파라미터의 값이 비어 있을 때 default value 속성을 설정. 
        log.info("ex3{},{}", user, age);
        
        model.addAttribute("name", user);
        model.addAttribute("age", age);
        
        return "ex2";
        
    }

    @PostMapping("/ex4")
    public String ex4(UserDto user, Model model) {
        log.info("ex4({})", user);
        // DispatcherServlet은
        // 1. 요청 파라미터들을 분석(request.getParameter).
        // 2. UserDto의 기본 생성자를 호출해서 객체를 생성.
        // 3. 요청 파라미터들의 이름으로 UserDto의 setter 메서드를 찾아서 호출.
        // 4. UserDto 객체를 컨트롤러 메서드를 호출할 때 argument로 전달.
        
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        
        return "ex2";
    }
    
    @GetMapping("/sample")
    public String sample() {
        log.info("sample()");
        return "sample"; // /WEB-INF/views/sample.jsp
    }
    
    @GetMapping("/ex-forward")
    public String exForward() {
        log.info("exForward()");
        return "forward:/sample";
    }
    
    @GetMapping("/ex-redirect")
    public String exRedirect() {
        log.info("exRedirect()");
        return "redirect:/sample";
    }
    
    
    
}
