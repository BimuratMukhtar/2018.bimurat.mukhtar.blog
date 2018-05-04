package impl;

import dao.AuthDao;
import dao.postgres.AuthDaoPostgres;
import kz.greetgo.blog.controller.register.TestRegister;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;


@Bean
public class AuthRegisterImpl implements TestRegister {

    public BeanGetter<AuthDao> registerDao;

//    @Override
//    public String getAuthText() {
//        return registerDao.get().getAuthText();
//    }
//
//    @Override
//    public void insertUser(String email, String password) {
//        registerDao.get().insertUser(email, password);
//    }

    @Override
    public String getText() {
        return registerDao.get().getAuthText();
    }
}
