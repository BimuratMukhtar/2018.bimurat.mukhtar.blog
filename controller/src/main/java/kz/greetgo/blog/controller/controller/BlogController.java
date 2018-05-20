package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.model.Blog;
import kz.greetgo.blog.controller.register.BlogRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.*;

import java.util.List;

import static kz.greetgo.mvc.core.RequestMethod.*;

@Bean
@Mapping("/blog")
public class BlogController implements Controller {

    public BeanGetter<BlogRegister> blogBean;

    @ToJson
    @MethodFilter(GET)
    @Mapping("")
    public List<Blog> getAllBlogs(){
        return blogBean.get().getBlogs();
    }

    @ToJson
    @MethodFilter(GET)
    @Mapping("/{id}")
    public Blog getBlogById(@ParPath("id") Integer id){
        return blogBean.get().getBlogDetail(id);
    }

    @ToJson
    @MethodFilter(POST)
    @Mapping("")
    public String addBlog(@ParamsTo Blog blog){
        return blogBean.get().addBlog(blog);
    }

    @ToJson
    @MethodFilter(DELETE)
    @Mapping("")
    public String deleteBlog(@Par("id") Integer id){
        return blogBean.get().deleteBlog(id);
    }

    @ToJson
    @MethodFilter(PUT)
    @Mapping("")
    public String editBlog(@ParamsTo Blog blog){
        return blogBean.get().editBlog(blog);
    }
}
