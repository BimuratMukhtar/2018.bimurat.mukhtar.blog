package kz.greetgo.blog.controller.register;

import kz.greetgo.blog.controller.model.Comment;

import java.util.List;

public interface CommentRegister {
    List<Comment> getCommentsByBlogId(Integer blogId);
    String editComment(Comment comment);
    String deleteComment(Integer commentId);
    String addComment(Comment comment);
}
