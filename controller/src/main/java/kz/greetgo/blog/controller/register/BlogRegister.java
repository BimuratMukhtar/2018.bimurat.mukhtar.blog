package kz.greetgo.blog.controller.register;

import kz.greetgo.blog.controller.model.Blog;

import java.util.List;

public interface BlogRegister {
    List<Blog> getBlogs();
    Blog getBlogDetail(Integer blogId);
    String addBlog(Blog blog);
    String deleteBlog(Integer id);
    String editBlog(Blog blog);
}
