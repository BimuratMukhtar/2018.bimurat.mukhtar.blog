package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.model.Comment;
import kz.greetgo.blog.controller.register.CommentRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.*;

import java.util.List;

import static kz.greetgo.mvc.core.RequestMethod.*;

@Bean
@Mapping("/comment")
public class CommentController implements Controller {
    public BeanGetter<CommentRegister> blogBean;

    @ToJson
    @MethodFilter(GET)
    @Mapping("")
    public List<Comment> getCommentByBlog(@Par("blogId") Integer blogId){
        return blogBean.get().getCommentsByBlogId(blogId);
    }

    @ToJson
    @MethodFilter(POST)
    @Mapping("")
    public String addComment(@ParamsTo Comment comment){
        return blogBean.get().addComment(comment);
    }

    @ToJson
    @MethodFilter(DELETE)
    @Mapping("")
    public String deleteComment(@Par("id") Integer id){
        return blogBean.get().deleteComment(id);
    }

    @ToJson
    @MethodFilter(PUT)
    @Mapping("")
    public String editBlog(@ParamsTo Comment comment){
        return blogBean.get().editComment(comment);
    }
}
