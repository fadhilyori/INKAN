package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.apps.inkan.MainActivity;

//import static com.apps.inkan.R.id.button_click;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends android.support.v4.app.Fragment {
    public static TextView data;

    Button btnEdit, btnJual, click;
    AppCompatActivity a = new AppCompatActivity();
    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_my_profile, container, false);
//        btnEdit = (Button) a.findViewById(R.id.btnEdit);
//        btnEdit.setOnClickListener(new OnClickListener() {
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        click = (Button) container.findViewById(R.id.button_click);
//        data = (TextView) container.findViewById(R.id.fetchdata);
//
//        click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FetchData process = new FetchData();
//                process.execute();
//            }
//        });

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_my_profile, container, false);

        btnEdit = (Button) view.findViewById(R.id.btnEdit);
        btnJual = (Button) view.findViewById(R.id.btnJual);
        btnJual.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), Penjualan.class));
                a.finish();
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplication(), EditProfilActivity.class));
                a.finish();
            }
        });
        return view;

    }
//    btnEdit = (Button) findViewById(R.id.btnEdit);
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view){
//            startActivity(new Intent(MyProfileFragment.this, EditProfilActivity.class));
//            finish();
//        });
}
