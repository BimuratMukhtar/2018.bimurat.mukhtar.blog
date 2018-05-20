package impl;

import dao.CommentDao;
import kz.greetgo.blog.controller.model.Comment;
import kz.greetgo.blog.controller.register.CommentRegister;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;

import java.util.List;

@Bean
public class CommentRegisterImpl implements CommentRegister {

    public BeanGetter<CommentDao> blogDao;

    @Override
    public List<Comment> getCommentsByBlogId(Integer blogId) {
        return blogDao.get().getCommentsByBlog(blogId);
    }

    @Override
    public String editComment(Comment comment) {
        blogDao.get().editComment(comment.content, comment.id);
        return "edited";
    }

    @Override
    public String deleteComment(Integer commentId) {
        blogDao.get().deleteComment(commentId);
        return "deleted";
    }

    @Override
    public String addComment(Comment comment) {
        blogDao.get().addComment(comment.content, comment.authorId, comment.blogId);
        return "comment added";
    }
}
