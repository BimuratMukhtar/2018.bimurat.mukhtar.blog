package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AuthDao {
    @Select("select text from users")
    String getAuthText();

    @Insert("insert into users(email, password, fullName) values (#{email, password, fullName})")
    String insertUser(String email, String password, String fullName);
}
