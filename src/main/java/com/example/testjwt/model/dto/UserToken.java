package com.example.testjwt.model.dto;

import com.example.testjwt.model.Role;

import java.util.List;

public class UserToken {
    private long id;
    private String userName;
    private String token;
    private List<Role> roles;

    public UserToken() {
    }

    public UserToken(long id, String userName, String token, List<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.token = token;
        this.roles = roles;
    }

//    public UserToken(String userName, String token, List<Role> roles) {
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
