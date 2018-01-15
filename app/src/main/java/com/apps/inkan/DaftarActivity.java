package com.apps.inkan;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.inkan.Model.UserModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;

public class DaftarActivity extends AppCompatActivity {
    EditText txtEmail, txtUsername, txtPassword;
    Button btnDaftar, btnLogin;
    String susername, semail, spassword;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtUsername = (EditText) findViewById(R.id.txtUsername);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSignIn();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                semail = txtEmail.getText().toString();
                susername = txtUsername.getText().toString();
                spassword = txtPassword.getText().toString();
                doSignUp(semail, susername, spassword);
            }
        });
    }

    private void doSignUp(String semail_data, String susername_data, String spassword_data){
        final ProgressDialog loading = new ProgressDialog(DaftarActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        loading.setMessage("Registering..");
        loading.show();
        APIService.service_post.postRegister(semail_data, susername_data, spassword_data).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                if(response.body().isStatus()){
                    loading.dismiss();
                    toSignIn();
                    finish();
                }else{
                    Toast.makeText(DaftarActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(DaftarActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void toSignIn(){
        //TODO PINDAH INTENT KE SIGNIN
        Intent intent = new Intent(DaftarActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
