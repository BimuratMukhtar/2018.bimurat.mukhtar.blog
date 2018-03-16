package kz.greetgo.blog.stand.login_impl;

import kz.greetgo.blog.controller.login.TestLogin;
import kz.greetgo.blog.controller.model.User;
import kz.greetgo.depinject.core.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Bean
public class TestLoginImpl implements TestLogin{

    public User [] users = {
            new User("bimurat.mukhtar@gmail.com", "1q2w3e4r", "Mukhtar"),
            new User("akhmed.kashymukhanuly@gmail.com", "1q2w3e4r", "Akhmed")
    };

    @Override
    public List<User> getUsers() {
        return Arrays.asList(users);
    }
}
