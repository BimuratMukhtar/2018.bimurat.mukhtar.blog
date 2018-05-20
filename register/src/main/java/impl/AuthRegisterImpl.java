package impl;

import dao.AuthDao;
import kz.greetgo.blog.controller.errors.RestError;
import kz.greetgo.blog.controller.model.User;
import kz.greetgo.blog.controller.register.AuthRegister;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;


@Bean
public class AuthRegisterImpl implements AuthRegister {

    public BeanGetter<AuthDao> registerDao;

    @Override
    public User loginUser(String email, String password) {
        User user = registerDao.get().getUser(email, password);
        if(user == null){
            throw new RestError(404);
        }
        return user;
    }

    @Override
    public String registerUser(String email, String password, String fullName) {
        return registerDao.get().insertUser(email, password, fullName);
    }
}
