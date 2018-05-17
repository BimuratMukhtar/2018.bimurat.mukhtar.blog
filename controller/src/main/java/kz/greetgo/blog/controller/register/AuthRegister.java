package kz.greetgo.blog.controller.register;

public interface AuthRegister {
    public String loginUser(String email, String password);
    public String registerUser(String email, String password, String fullName);
}
