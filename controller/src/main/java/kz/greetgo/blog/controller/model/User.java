package kz.greetgo.blog.controller.model;

public class User {

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String login;
    public String password;
    public String name;
}
