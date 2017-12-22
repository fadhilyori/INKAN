package com.apps.inkan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by user on 22/12/2017.
 */

public class GetUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<User> ListDataUser;
    @SerializedName("message")
    String message;

    public GetUser () {}

    public GetUser(String status, List<User> listDataUser, String message) {
        this.status = status;
        ListDataUser = listDataUser;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List<User> getListDataUser() {
        return ListDataUser;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setListDataUser(List<User> listDataUser) {
        ListDataUser = listDataUser;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
