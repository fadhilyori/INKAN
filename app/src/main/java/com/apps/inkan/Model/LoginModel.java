package com.apps.inkan.Model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

/**
 * Created by user on 22/12/2017.
 */

public class LoginModel {

    private Boolean status;
    private String message;
    private String authKey;
    private String username;
    private String email;

    public Boolean isStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthKey() {
        return authKey;
    }

    public String getUsername() {
        return username;
    }
}
