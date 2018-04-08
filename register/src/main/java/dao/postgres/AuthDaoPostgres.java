package dao.postgres;

import dao.AuthDao;
import kz.greetgo.depinject.core.Bean;
import org.apache.ibatis.annotations.Select;

@Bean
public interface AuthDaoPostgres extends AuthDao {

}
