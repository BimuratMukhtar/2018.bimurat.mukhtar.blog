package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.login.TestLogin;
import kz.greetgo.blog.controller.model.User;
import kz.greetgo.blog.controller.register.TestRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParamsTo;
import kz.greetgo.mvc.annotations.ToJson;

import java.util.List;

@Bean
public class TestController implements Controller {

    public BeanGetter<TestRegister> testRegisterBean;
    public BeanGetter<TestLogin> testLoginBean;

    @ToJson
    @Mapping("/getMainText")
    public String getMainText(){
        return testRegisterBean.get().getText();
    }

    @ToJson
    @Mapping("/getUsers")
    public String getUsers(@Par("login") String login, @Par("password") String password){
        System.out.println(login + " "+password);
        for (User user : testLoginBean.get().getUsers()){
            if(user.login.equals(login) && user.password.equals(password)){
                return user.name;
            }
        }
        return "failed";
    }
}
