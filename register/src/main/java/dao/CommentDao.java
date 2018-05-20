package dao;

import kz.greetgo.blog.controller.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentDao {
    @Select("select * from comments where blogId = #{blogId}")
    List<Comment> getCommentsByBlog(@Param("blogId") Integer blogId);

    @Insert("insert into comments values(default, #{content}, #{authorId}, #{blogId}, default)")
    void addComment(@Param("content") String content,
                    @Param("authorId") Integer authorId,
                    @Param("blogId") Integer blogId);

    @Update("update comments set content = #{content} where id=#{id}")
    void editComment(@Param("content") String content, @Param("id") Integer commentId);

    @Delete("delete from comment where id = #{id}")
    void deleteComment(@Param("id") Integer id);
}
