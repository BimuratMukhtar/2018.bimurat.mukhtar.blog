package impl;

import dao.BlogDao;
import kz.greetgo.blog.controller.model.Blog;
import kz.greetgo.blog.controller.register.BlogRegister;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;

import java.util.List;

@Bean
public class BlogRegisterImpl implements BlogRegister {

    public BeanGetter<BlogDao> blogDao;

    @Override
    public List<Blog> getBlogs() {
        return blogDao.get().getBlogs();
    }

    @Override
    public Blog getBlogDetail(Integer blogId) {
        return blogDao.get().getBlogById(blogId);
    }

    @Override
    public String addBlog(Blog blog) {
        blogDao.get().addBlog(blog.title, blog.authorId, blog.content, blog.imageUrl);
        return "success";
    }

    @Override
    public String deleteBlog(Integer id) {
        blogDao.get().deleteBlog(id);
        return "deleted";
    }

    @Override
    public String editBlog(Blog blog) {
        blogDao.get().editBlog(blog.title, blog.content, blog.imageUrl, blog.id);
        return "edited";
    }
}
