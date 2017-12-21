package com.apps.inkan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DaftarActivity extends AppCompatActivity {

    Button btnDaftar, btnToLogin;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        getSupportActionBar().hide();

        btnDaftar = (Button) findViewById(R.id.btnDaftarLogin);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
                finish();
            }
        });

        btnToLogin = (Button) findViewById(R.id.btnToLogin);
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
