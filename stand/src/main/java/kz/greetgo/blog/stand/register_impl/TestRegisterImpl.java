package kz.greetgo.blog.stand.register_impl;

import kz.greetgo.blog.controller.register.TestRegister;
import kz.greetgo.depinject.core.Bean;

@Bean
public class TestRegisterImpl implements TestRegister{

    @Override
    public String getText() {
        return "This is test stand version";
    }
}
