package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AuthDao {
    @Select("select text from users")
    String getAuthText();

    @Insert("insert into users(email, password) values (#{email, password})")
    void insertUser(String email, String password);
}
