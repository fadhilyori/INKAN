package com.apps.inkan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.inkan.Model.LoginModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    ProgressDialog loading;
    String username, password;

    Context mContext;
    APIService mApiService;
    Button btnMasuk, btnDaftar;

    public void saveInfo (View view) {
        SharedPreferences sharedPref = getSharedPreferences("username", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", txtUsername.getText().toString());
        editor.putString("password", txtPassword.getText().toString());
        editor.apply();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getSupportActionBar().hide();
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);

//        btnMasuk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                finish();
//            }
//        });
//
//
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
                finish();
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO LOGIN
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    doSignIn(username, password);
                } else {
                    Toast.makeText(LoginActivity.this, "data kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void doSignIn(final String username, final String password) {
        loading = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        loading.setMessage("Authenticating..");
        loading.show();

        APIService.service_post.postLogin(username, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                // if untuk intent ke fragment
                if(response.body().isStatus()) {
                    loading.dismiss();
                    Intent dashboard = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(dashboard);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

            }
        });
    }
}