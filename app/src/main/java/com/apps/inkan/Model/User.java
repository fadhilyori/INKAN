package com.apps.inkan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 22/12/2017.
 */

public class User {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public User () {}

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
