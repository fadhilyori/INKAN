package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.inkan.Model.Sale;
import com.apps.inkan.rest.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FishMarket_Hot_Promo extends Fragment {
    LinearLayout hotPromo;
//    AppCompatActivity a = new AppCompatActivity();
//    TextView detailArtikel;
    ImageView detailartikel;
    AppCompatActivity a = new AppCompatActivity();
    RecyclerView rvDataArtikel;
    Sale listdataArtikel;
    String judul, deskripsi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pengetahuan, container, false);
//        rvDataArtikel = (RecyclerView) view.findViewById(R.id.judulartikel);
//        LinearLayoutManager llmData = new LinearLayoutManager(getActivity().getApplicationContext());
//        rvDataArtikel.setLayoutManager(llmData);
//
//        APIService.service_get.getArtikel(judul, deskripsi).enqueue(new Callback<>() {
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
//
//            @Override
//            public void onFailure(Call<Artikel> call, Throwable t) {
//            }
//        });
        return view;


//        hotPromo = (LinearLayout) view.findViewById(R.id.hotPromo);
//        hotPromo.setOnClickListener(new View.OnClickListener() {
//            public void onClick (View view) {
//                startActivity(new Intent(getActivity().getApplication(), DetailHotPromoActivity.class));
//                a.finish();
//            }
//        });
    }

}
