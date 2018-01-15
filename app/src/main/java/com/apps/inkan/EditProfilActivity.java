package com.apps.inkan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.apps.inkan.Model.User;
import com.apps.inkan.Model.UserModel;
import com.apps.inkan.rest.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {
    Button simpan, btnChoose;
    EditText tvUsername, tvEmail, tvAlamat, tvTelp;
    String susername, semail, salamat, stelp;
    ProgressDialog progressDialog;
    String mediaPath = "";
    ImageView preview;
    ImageButton btnBack;


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

    public void displayData (View view) {
        SharedPreferences sharePref = getSharedPreferences("username", Context.MODE_PRIVATE);
        String username = sharePref.getString("username", "");
        String email = sharePref.getString("email", "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        simpan = (Button) findViewById(R.id.simpan);
        tvUsername = (EditText) findViewById(R.id.tvUsername);
        tvEmail = (EditText) findViewById(R.id.tvEmail);
        tvAlamat = (EditText) findViewById(R.id.tvAlamat);
        tvTelp = (EditText) findViewById(R.id.tvTelp);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfilActivity.this, MyProfileFragment.class);
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




        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                susername = tvUsername.getText().toString();
                semail = tvEmail.getText().toString();
                stelp = tvTelp.getText().toString();
                salamat = tvAlamat.getText().toString();
                doUpdate(susername, salamat, semail, stelp);
            }
        });

    }

    private void doUpdate(String susername_data, String semail_data, String stelp_data, String salamat_data) {
        final ProgressDialog loading = new ProgressDialog(EditProfilActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        loading.setMessage("Memperbaruhi..");
        loading.show();
        APIService.service_post.postUser(susername_data, semail_data, stelp_data, salamat_data).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                if (response.body().isStatus()) {
                    loading.dismiss();
                    Intent intent = new Intent(EditProfilActivity.this, MyProfileFragment.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditProfilActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(EditProfilActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}
