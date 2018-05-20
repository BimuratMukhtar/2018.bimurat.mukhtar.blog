package kz.greetgo.blog.controller.model;

public class User {

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public User(){

    }

    public Integer id;
    public String login;
    public String password;
    public String fullName;
}
