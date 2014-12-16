package com.arcane.model;

import java.io.Serializable;

/**
 * Created by DELL on 11/22/2014.
 */
public class User implements Serializable {
    private Integer userid;
    private String username;
    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
