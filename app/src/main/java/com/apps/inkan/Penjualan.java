package com.apps.inkan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.Model.Sale;
import com.apps.inkan.Model.SaleModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;


public class Penjualan extends AppCompatActivity {
    ImageButton back;
    Button btnUpload;
    EditText nama, jenis, deskripsi, harga;
    String snama, sdeskripsi, sjenis;
    int sharga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_artikel);

        nama = (EditText) findViewById(R.id.nama);
        deskripsi = (EditText) findViewById(R.id.deskripsi);
        harga = (EditText) findViewById(R.id.harga);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Penjualan.this, PengetahuanFragment.class);
                startActivity(intent);
            }
        });

//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                snama = nama.getText().toString();
//                sharga = harga.getText().toString();
//                sdeskripsi = deskripsi.getText().toString();
//                doCreate(snama, sharga, sdeskripsi);
//            }
//        });
    }

//    private void doCreate (String snama_data, String sdeskripsi_data, int sharga_data){
//        final ProgressDialog loading = new ProgressDialog(Penjualan.this, R.style.Theme_AppCompat_DayNight_Dialog);
//        loading.setMessage("Uploading..");
//        loading.show();
//        APIService.service_post.postSale(snama_data, sdeskripsi_data, sharga_data).enqueue(new Callback<SaleModel>() {
//            @Override
//            public void onResponse(Call<SaleModel> call, retrofit2.Response<SaleModel> response) {
//                if(response.body().isStatus()){
//                    loading.dismiss();
//                    Intent intent = new Intent(Penjualan.this, FishMarket_Hot_Promo.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(Penjualan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    loading.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SaleModel> call, Throwable t) {
//                Toast.makeText(Penjualan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
