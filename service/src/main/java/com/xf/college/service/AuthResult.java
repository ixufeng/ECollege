package com.xf.college.service;


import com.xf.college.model.User;

/**
 * Created by xufeng on 2017/4/15.
 */

public class AuthResult {

    private boolean login = false;
    private String message = null;
    private User user = null;
    private String redirect;


    public AuthResult() {

    }

    public AuthResult(boolean login, String message) {
        this.login = login;
        this.message = message;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
