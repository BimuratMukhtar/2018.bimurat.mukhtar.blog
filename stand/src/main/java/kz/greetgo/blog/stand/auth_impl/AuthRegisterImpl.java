package kz.greetgo.blog.stand.auth_impl;

import kz.greetgo.blog.controller.register.AuthRegister;
import kz.greetgo.blog.controller.model.User;
import kz.greetgo.depinject.core.Bean;

@Bean
public class AuthRegisterImpl implements AuthRegister {

    public User [] users = {
            new User("bimurat.mukhtar@gmail.com", "1q2w3e4r", "Mukhtar"),
            new User("akhmed.kashymukhanuly@gmail.com", "1q2w3e4r", "Akhmed")
    };

    @Override
    public String loginUser(String email, String password) {
        for (User user : users){
            if(user.login.equals(email) && user.password.equals(password)){
                return user.fullName;
            }
        }
        return "Invalid UserName or Password";
    }

    @Override
    public String registerUser(String email, String password, String fullName) {
        return "You are registered";
    }
}
