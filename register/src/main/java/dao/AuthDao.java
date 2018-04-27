package dao;

import org.apache.ibatis.annotations.Select;

public interface AuthDao {
    @Select("select text from test_table")
    String getAuthText();
}
