package dao;

import kz.greetgo.blog.controller.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AuthDao {
    @Select("select * from users where email=#{email} and passord=#{password}")
    User getUser(@Param("email")String email, @Param("password")String password);

    @Insert("insert into users(email, password, fullName) values (#{email, password, fullName})")
    String insertUser(@Param("email")String email, @Param("password")String password, @Param("fullName")String fullName);
}
