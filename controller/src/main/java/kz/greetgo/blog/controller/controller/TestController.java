package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.login.TestLogin;
import kz.greetgo.blog.controller.register.TestRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;

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
    @Mapping("/loginUser")
    public String getUsers(@Par("login") String login, @Par("password") String password){

        return testLoginBean.get().loginUser(login, password);
    }
}
