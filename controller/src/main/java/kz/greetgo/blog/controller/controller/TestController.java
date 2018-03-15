package kz.greetgo.blog.controller.controller;

import kz.greetgo.blog.controller.register.TestRegister;
import kz.greetgo.blog.controller.utils.Controller;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
public class TestController implements Controller {

    public BeanGetter<TestRegister> testRegisterBean;

    @ToJson
    @Mapping("/getMainText")
    public String getMainText(){
        return testRegisterBean.get().getText();
    }
}
