package com.apps.inkan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.inkan.Model.User;
import com.apps.inkan.Model.UserModel;
import com.apps.inkan.rest.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {
    Button simpan;
    EditText tvUsername, tvEmail, tvAlamat, tvTelp;
    String susername, semail, salamat, stelp;

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
