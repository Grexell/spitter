package by.dima.security;

import javax.servlet.http.HttpServletRequest;

public interface UserLogin {
    void login(HttpServletRequest request, String username, String password);
}
