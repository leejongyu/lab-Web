package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.dto.PostUpdatedto;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post") // -> @RequestMappin 애너테이션을 설정하면, 그 클래스의 모든 메서드들의 매핑 주소는 @RequestMapping에서 설정된 URL로 시작함.
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입

    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        
        // service 계층의 메서드를 사용해서 포스트 전체 목록을 검색함.
        List<Post> list = postService.read();

        // view
        model.addAttribute("list", list);

        return "/post/list";
    }

    // 목록보기/ 새 글 작성 / 상세보기/ 수정 페이지 / 수정/ 삭제 컨트롤러 메서드
    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        log.info("detail() + id = {}", id);

        Post post = postService.detail(id);

        model.addAttribute("post", post);

        return "/post/detail";
    }

    @GetMapping("/modify")
    public String modify(Integer id, Model model) {
        log.info("modify() + id = {}", id);

        Post post = postService.detail(id);

        model.addAttribute("post", post);

        return "/post/modify";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {

        int result = postService.delete(id);
        log.info("delete id = {}", id, result);

        List<Post> list = postService.read();
        model.addAttribute("list", list);

        return "/post/list";
    }

    @PostMapping("/update")
    public String update(Integer id, String title, String content, Model model) {

        Post post = Post.builder().id(id).title(title).content(content).build();

        int result = postService.update(post);
        log.info("update id = {} title = {} content = {}", id, title, content, result);

        post = postService.detail(id);

        model.addAttribute("post", post);

        return "/post/detail";
    }

    @GetMapping("/create")
    public String getcreate() {
        log.info("create");
        return "/post/create";
    }

    @PostMapping("/create")
    public String postcreate(String title, String content, String author, Model model) {
        

        Post post = Post.builder().title(title).content(content).author(author).build();
        
        int result = postService.insert(post);
        
        List<Post> list = postService.read();

        log.info("{}, {}, {}, {}",title, content, author, result);
        
        model.addAttribute("list", list);

        return "redirect:/post/list";
    }
    
    @GetMapping("/tcreate")
    public String gettemplete() {
        log.info("templete");
        return "/post/tcreate";
    }
    
    @PostMapping("/tcreate")
    public String gettemplete(PostCreateDto dto) {
        
        postService.tcreate(dto);
        
        log.info("templete-create (dto = {})", dto);
        
        return "redirect:/post/tlist";
    }
    
    @GetMapping("/tlist")
    public String tlist(Model model) {
        log.info("list()");
        
        // service 계층의 메서드를 사용해서 포스트 전체 목록을 검색함.
        List<Post> list = postService.read();

        // view
        model.addAttribute("list", list);

        return "/post/tlist";
    }
    
    @GetMapping("/tdetail")
    public String tdtail(Integer id, Model model) {
        log.info("T-detail id = {}",id);
        
       Post post = postService.read(id);
       
       model.addAttribute("post", post);
        
        return "/post/tdetail";
    }
    
    @GetMapping("/tmodify")
    public String tmodify(Integer id, Model model) {
        log.info("modify() id = {}", id);
        
        Post post = postService.read(id);
        
        model.addAttribute("post", post);
        
        return "/post/tmodify";
    }
    
    @PostMapping("/tupdate")
    public String tupdate(PostUpdatedto dto) {
        log.info("update(dto = {})" , dto);
        
        
        postService.tupdate(dto);
        
        return "redirect:/post/tdetail?id="+dto.getId();
    }
    
    @PostMapping("/tdelete")
    public String tdelete(Integer id) {
        log.info("delete() id = {}", id);

        postService.delete(id);
        
        return "redirect:/post/tlist";
    }
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        
        log.info("search(dto = {})",dto);
        
        List<Post> list = postService.search(dto);
        
        model.addAttribute("list", list);
        
        return "post/tlist";
        
    }
    
}
