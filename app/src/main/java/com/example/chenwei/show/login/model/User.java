package com.example.chenwei.show.login.model;

/**
 * Created by chenwei on 17/1/25.
 */

public class User {

    private String userName;
    private String passport;

    public User(String userName, String passport) {
        this.userName = userName;
        this.passport = passport;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
