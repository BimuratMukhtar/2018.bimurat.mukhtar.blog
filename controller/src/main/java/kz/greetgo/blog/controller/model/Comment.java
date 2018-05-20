package kz.greetgo.blog.controller.model;

public class Comment {
    public Integer id;
    public String content;
    public Integer authorId;
    public String author;
    public Integer blogId;
    public String createdDate;

    public Comment(){

    }

    public Comment(String content, Integer authorId, String author, Integer blogId) {
        this.content = content;
        this.authorId = authorId;
        this.author = author;
        this.blogId = blogId;
    }
}
