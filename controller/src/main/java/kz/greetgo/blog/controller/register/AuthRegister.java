package kz.greetgo.blog.controller.register;

import kz.greetgo.blog.controller.model.User;

public interface AuthRegister {
    User loginUser(String email, String password);
    String registerUser(String email, String password, String fullName);
}
