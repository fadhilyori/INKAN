package com.apps.inkan;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.apps.inkan.Model.Artikel;
import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.Model.UserModel;
import com.apps.inkan.rest.APIService;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Multipart;

public class FormArtikelActivity extends AppCompatActivity {
    Button btnUpload, btnChoose;
    ImageButton btnBack;
    EditText judul, deskripsi;
    String sjudul, sdeskripsi, spicture;
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
            Toast.makeText(this, mediaPath, Toast.LENGTH_SHORT).show();
            Bitmap bmp = BitmapFactory.decodeFile(mediaPath);
            preview.setImageBitmap(bmp);
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
        setContentView(R.layout.activity_form_artikel);

        requestPermission();

        preview = (ImageView) findViewById(R.id.preview);
        judul = (EditText) findViewById(R.id.judul);
        deskripsi = (EditText) findViewById(R.id.deskripsi);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        progressDialog = new ProgressDialog(this);
        btnUpload = findViewById(R.id.btnUpload);
        progressDialog.setMessage("Uploading ...");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormArtikelActivity.this, PengetahuanFragment.class);
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


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                sjudul = judul.getText().toString();
                sdeskripsi = deskripsi.getText().toString();
                uploadData();
            }
        });
    }

    private void uploadData() {
        uploadFile();
        uploadForm(sjudul, sdeskripsi);
    }

    private void uploadFile() {
        File file = new File(mediaPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("picture", file.getName());
        RequestBody fileName = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        APIService.service_post.postArtikelMultipart( multipartBody, fileName).enqueue(new Callback<ArtikelModel>() {
            @Override
            public void onResponse(Call<ArtikelModel> call, retrofit2.Response<ArtikelModel> response) {
                if (response.body().isStatus()) {
                    progressDialog.dismiss();
                } else {
                    Toast.makeText(FormArtikelActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArtikelModel> call, Throwable t) {
                Toast.makeText(FormArtikelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadForm(String sjudul, String sdeskripsi) {
        APIService.service_post.postArtikel(sjudul, sdeskripsi).enqueue(new Callback<ArtikelModel>() {
            @Override
            public void onResponse(Call<ArtikelModel> call, retrofit2.Response<ArtikelModel> response) {
                if(response.body().isStatus()){
                    progressDialog.dismiss();
                    Intent intent = new Intent(FormArtikelActivity.this, PengetahuanFragment.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(FormArtikelActivity.this, "data kosong", Toast.LENGTH_SHORT).show();
                }
            }
              @Override
            public void onFailure(Call<ArtikelModel> call, Throwable t) {
                Toast.makeText(FormArtikelActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

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

