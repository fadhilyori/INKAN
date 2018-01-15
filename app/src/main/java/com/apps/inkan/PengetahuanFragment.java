package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.inkan.Adapter.DataArtikelAdapter;
import com.apps.inkan.Model.Artikel;
import com.apps.inkan.Model.ArtikelModel;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PengetahuanFragment extends android.support.v4.app.Fragment {
    TextView detailArtikel;
    ImageView detailartikel;
    AppCompatActivity a = new AppCompatActivity();
    RecyclerView rvDataArtikel;
    Artikel listdataArtikel;
    String judul, deskripsi;
    FloatingActionButton btnArtikel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pengetahuan, container, false);
//        rvDataArtikel = (RecyclerView) view.findViewById(R.id.judulartikel);
//        LinearLayoutManager llmData = new LinearLayoutManager(getActivity().getApplicationContext());
//        rvDataArtikel.setLayoutManager(llmData);

        btnArtikel = (FloatingActionButton) view.findViewById(R.id.btnArtikel);
        btnArtikel.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), FormArtikelActivity.class));
//                a.finish();
            }
        });


//        APIService.service_get.getArtikel(judul, deskripsi).enqueue(new Callback<Artikel>() {
//            private Call<Artikel> call;
//            private Response<Artikel> response;
//
//            @Override
//            public void onResponse(Call<Artikel> call, Response<Artikel> response) {
//                this.call = call;
//                this.response = response;
//                listdataArtikel = response.body();
//                DataArtikelAdapter adapter = new DataArtikelAdapter(getContext(), listdataArtikel);
//                rvDataArtikel.setAdapter(adapter);
//            }
//            @Override
//            public void onFailure(Call<Artikel> call, Throwable t) {
//            }
//        });
        return view;

//        Intent mengarahkan ke detail artikel
//        detailArtikel = (TextView) view.findViewById(R.id.judulartikel);
//        detailartikel = (ImageView) view.findViewById(R.id.gambarartikel);
//        detailartikel.setOnClickListener(new View.OnClickListener() {
//            public void onClick (View view) {
//                startActivity(new Intent(getActivity().getApplication(), DetailPengetahuanActivity.class));
//                a.finish();
//            }
//        });
//        detailArtikel.setOnClickListener(new View.OnClickListener() {
//            public void onClick (View view) {
//                startActivity(new Intent(getActivity().getApplication(), DetailPengetahuanActivity.class));
//                a.finish();
//            }
//        });
//        return view;
    }

}
