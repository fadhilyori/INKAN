package com.apps.inkan.Model;

import java.util.ArrayList;

/**
 * Created by user on 30/12/2017.
 */

public class ArtikelModel {
    private boolean status;
    private String message;
    private ArrayList<Artikel> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Artikel> getData() {
        return data;
    }
}
