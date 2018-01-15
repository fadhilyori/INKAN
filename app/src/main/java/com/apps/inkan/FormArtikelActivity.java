package com.apps.inkan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.inkan.Model.Artikel;
import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;

public class FormArtikelActivity extends AppCompatActivity {
    Button btnUpload;
    EditText judul, deskripsi;
    String sjudul, sdeskripsi, spicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_artikel);

        judul = (EditText) findViewById(R.id.judul);
        deskripsi = (EditText) findViewById(R.id.deskripsi);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormArtikelActivity.this, PengetahuanFragment.class);
                startActivity(intent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sjudul = judul.getText().toString();
                sdeskripsi = deskripsi.getText().toString();
                doCreate(sjudul, sdeskripsi);
            }
        });
    }

    private void doCreate (String sjudul_data, String sdeskripsi_data){
        final ProgressDialog pDialog = new ProgressDialog(FormArtikelActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        pDialog.setMessage("Uploading..");
        pDialog.show();
        APIService.service_post.postAtikel(sjudul_data, sdeskripsi_data).enqueue(new Callback<ArtikelModel>() {
            @Override
            public void onResponse(Call<ArtikelModel> call, retrofit2.Response<ArtikelModel> response) {
                if(response.body().isStatus()){
                    pDialog.dismiss();
                    Intent intent = new Intent(FormArtikelActivity.this, PengetahuanFragment.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(FormArtikelActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    pDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArtikelModel> call, Throwable t) {
                Toast.makeText(FormArtikelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
