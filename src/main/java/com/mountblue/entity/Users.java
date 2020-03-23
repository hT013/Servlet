package com.mountblue.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class Users {

    @Id
    private String email;
    private String userName;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}