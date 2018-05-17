package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.register.AuthRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
public class AuthController implements Controller {

    public BeanGetter<AuthRegister> authBean;

    @ToJson
    @Mapping("/register")
    public String register(@Par("login") String login, @Par("password") String password, @Par("fullName") String fullName){
        return authBean.get().registerUser(login, password, fullName);
    }

    @ToJson
    @Mapping("/login")
    public String login(@Par("login") String login, @Par("password") String password){
        return authBean.get().loginUser(login, password);
    }
}
