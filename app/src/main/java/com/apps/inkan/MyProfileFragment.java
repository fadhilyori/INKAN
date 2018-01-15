package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.apps.inkan.MainActivity;
import com.apps.inkan.Model.UserModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import static com.apps.inkan.R.id.button_click;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends android.support.v4.app.Fragment {
    public static TextView data;
    RecyclerView rvDataProfil;
    UserModel listdatauser;

    Button btnEdit, btnJual, click;
    AppCompatActivity a = new AppCompatActivity();



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        // mengarahkan button

        btnEdit = (Button) view.findViewById(R.id.btnEdit);
        btnJual = (Button) view.findViewById(R.id.btnJual);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplication(), EditProfilActivity.class));
                a.finish();
            }
        });
        btnJual.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), Penjualan.class));
//                a.finish();
            }
        });
        getActivity().setTitle("Profil Saya");
        return view;
    }
}
