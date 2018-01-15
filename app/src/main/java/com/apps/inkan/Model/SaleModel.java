package com.apps.inkan.Model;

import java.util.ArrayList;

/**
 * Created by user on 30/12/2017.
 */

public class SaleModel {
    private boolean status;
    private String message;
    private ArrayList<Sale> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Sale> getData() {
        return data;
    }
}
