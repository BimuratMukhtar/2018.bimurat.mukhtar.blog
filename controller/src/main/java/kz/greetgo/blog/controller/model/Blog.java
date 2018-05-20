package kz.greetgo.blog.controller.model;

public class Blog {
    public Integer id;
    public String title;
    public Integer authorId;
    public String createdDate;
    public String content;
    public String imageUrl;

    public Blog(){

    }

    public Blog(String title, Integer authorId, String content, String imageUrl) {
        this.title = title;
        this.authorId = authorId;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
