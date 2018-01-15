package com.apps.inkan.Model;

/**
 * Created by user on 30/12/2017.
 */

public class Sale {
    private int id, fish_kategori_id, fish_id, harga;
    private String keterangan, gambar;

    public int getId()
    {
        return id;
    }

    public int getFish_kategori_id()
    {
        return fish_kategori_id;
    }

    public int getFish_id()
    {
        return fish_id;
    }

    public int getHarga()
    {
        return harga;
    }

    public String getKeterangan()
    {
        return keterangan;
    }

    public String getGambar()
    {
        return gambar;
    }
}
