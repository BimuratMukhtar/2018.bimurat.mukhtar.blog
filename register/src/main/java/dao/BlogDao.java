package dao;

import kz.greetgo.blog.controller.model.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface BlogDao {

    @Select("select * from blogs")
    List<Blog> getBlogs();

    @Select("select * from blogs where id = #{id}")
    Blog getBlogById(@Param("id") Integer id);

    @Insert("insert into blogs values(default, #{title}, #{authorId}, default, #{content}, #{imageUrl})")
    void addBlog(@Param("title") String title,
                 @Param("authorId") Integer authorId,
                 @Param("content") String content,
                 @Param("imageUrl") String imageUrl);

    @Update("update blogs set title=#{title}, content = #{content}, imageUrl = #{imageUrl} where id=#{id}")
    void editBlog(@Param("title") String title,
                  @Param("content") String content,
                  @Param("imageUrl") String imageUrl,
                  @Param("id") Integer blogId);

    @Delete("delete from blogs where id = #{id}")
    void deleteBlog(@Param("id") Integer id);
}
