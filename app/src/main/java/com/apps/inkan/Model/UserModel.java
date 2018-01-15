package com.apps.inkan.Model;

import java.util.ArrayList;

/**
 * Created by user on 30/12/2017.
 */

public class UserModel {
    private boolean status;
    private String message;
    private ArrayList<User> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<User> getData() {
        return data;
    }
}
