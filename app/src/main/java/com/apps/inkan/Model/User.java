package com.apps.inkan.Model;


import com.google.gson.annotations.SerializedName;
/**
 * Created by user on 28/12/2017.
 */

public class User {
    private int id, phone_number, provinsi_id, sale_id;
    private String username, email, address, pictures;

    public int getId() {
        return id;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public int getProvinsi_id() {
        return provinsi_id;
    }

    public int getSale_id() {
        return sale_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPictures() {
        return pictures;
    }
}
