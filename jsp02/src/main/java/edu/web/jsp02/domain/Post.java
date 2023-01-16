package edu.web.jsp02.domain;

import java.time.LocalDateTime;

// MVC 아키택처에서 Model에 해당하는 클래스. DB의 POSTS 테비을의 내용.
// Model class : (1) 필드, (2) 생정자, (3) getters, (4) Builder
public class Post {

    private Integer id; // 글 번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 작성자
    private LocalDateTime createdTime; // 최초 작성 시간
    private LocalDateTime modifiedTime; // 최종 작성 시간

    public Post() {
    } // 기본 생성자

    // 모든 field를 argument로 갖는 생성자
    public Post(Integer id, String title, String content, String author, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
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

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return "자유게시판 [글 번호 = " + id + ", 제목 = " + title + ", 내용 = " + content + ", 작성자 = " + author + ", 작성 시간 = "
                + createdTime + ", 수정 시간 = " + modifiedTime + "]";
    }

    // Builder(Factory) 패턴
    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public static class PostBuilder {
        private Integer id; // 글 번호
        private String title; // 글 제목
        private String content; // 글 내용
        private String author; // 작성자   
        private LocalDateTime createdTime; // 최초 작성 시간
        private LocalDateTime modifiedTime; // 최종 작성 시간

        public PostBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostBuilder author(String author) {
            this.author = author;
            return this;
        }

        public PostBuilder createdTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public PostBuilder modifiedTime(LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;

        }

        public Post build() {
            return new Post(id, title, content, author, createdTime, modifiedTime);
        }
    }
}