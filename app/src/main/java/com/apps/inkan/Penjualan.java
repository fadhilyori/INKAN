package com.apps.inkan;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.Model.Sale;
import com.apps.inkan.Model.SaleModel;
import com.apps.inkan.rest.APIService;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


public class Penjualan extends AppCompatActivity {
    ImageButton btnBack;
    Button btnUpload, btnChoose;
    EditText nama, jenis, deskripsi, harga, kategori;
    String snama, sketerangan, sharga, sjenis, skategori;
    ProgressDialog progressDialog;
    String mediaPath = "";
    ImageView preview;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK && data!= null)
        {
            Uri selectedImage = data.getData();
            Log.v("uri", selectedImage.toString());
            String[] filePathColumn = {
                    MediaStore.Images.Media.DATA
            };
            Log.v("test", "Test1");
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            Log.v("test", "Test2");
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            mediaPath = cursor.getString(columnIndex);

            Log.v("test", "Test3");
            preview.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
            cursor.close();
        }
        else
        {
            Toast.makeText(this, "you havn't picked any file", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);
        requestPermission();


        nama = (EditText) findViewById(R.id.nama);
        deskripsi = (EditText) findViewById(R.id.deskripsi);
        harga = (EditText) findViewById(R.id.harga);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Penjualan.this, FishMarketFragment.class);
                finish();
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressDialog.show();
//                snama = nama.getText().toString();
//                sketerangan = deskripsi.getText().toString();
//                sharga = harga.getText().toString();
//                sjenis = jenis.getText().toString();
//                skategori = kategori.getText().toString();
//                uploadData();
//            }
//        });
//    }
//    private void uploadData() {
//        uploadFile();
//        uploadForm(sketerangan, sjenis, sharga);
    }

//    private void uploadFile() {
//        File file = new File(mediaPath);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
//        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("gambar", file.getName());
//        RequestBody fileName = RequestBody.create(MediaType.parse("text/plain"), file.getName());
//
//        APIService.service_post.postSaleMultipart( multipartBody, fileName).enqueue(new Callback<SaleModel>() {
//            @Override
//            public void onResponse(Call<SaleModel> call, retrofit2.Response<SaleModel> response) {
//                if (response.body().isStatus()) {
//                    progressDialog.dismiss();
//                } else {
//                    Toast.makeText(Penjualan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SaleModel> call, Throwable t) {
//                Toast.makeText(Penjualan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void uploadForm(String sketerangan, int sjenis, int sharga) {
//        APIService.service_post.postSale(sketerangan, sharga, skategori, sjenis).enqueue(new Callback<SaleModel>() {
//            @Override
//            public void onResponse(Call<SaleModel> call, retrofit2.Response<SaleModel> response) {
//                if(response.body().isStatus()){
//                    progressDialog.dismiss();
//                    Intent intent = new Intent(Penjualan.this, PengetahuanFragment.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(Penjualan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            }
//            @Override
//            public void onFailure(Call<SaleModel> call, Throwable t) {
//                Toast.makeText(Penjualan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


    private void requestPermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE))
            {
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
            }
        }
    }
}