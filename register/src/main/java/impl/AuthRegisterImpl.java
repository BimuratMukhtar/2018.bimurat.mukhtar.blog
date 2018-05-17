package impl;

import dao.AuthDao;
import kz.greetgo.blog.controller.register.AuthRegister;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;


@Bean
public class AuthRegisterImpl implements AuthRegister {

    public BeanGetter<AuthDao> registerDao;

    @Override
    public String loginUser(String email, String password) {
        return registerDao.get().getAuthText();
    }

    @Override
    public String registerUser(String email, String password, String fullName) {
        return registerDao.get().insertUser(email, password, fullName);
    }
}
