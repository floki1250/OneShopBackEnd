package com.oneshopproject.oneshopproject;

public class User {
    int id ;
    String User = "" ;
    String Password = "" ;

    public User(int id, String user, String password) {
        this.id = id;
        User = user;
        Password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
