package edu.web.jsp01.domain;

import java.time.LocalDateTime;

public class Post {

    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;

    public Post() {
    }

    public Post(Integer id, String title, String content, LocalDateTime createTime) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime + "]";
    }

    
        
}
