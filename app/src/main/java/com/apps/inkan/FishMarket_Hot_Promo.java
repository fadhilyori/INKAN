package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FishMarket_Hot_Promo extends Fragment {
    LinearLayout hotPromo;
    AppCompatActivity a = new AppCompatActivity();

    public FishMarket_Hot_Promo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fish_market__hot__promo, container, false);

        hotPromo = (LinearLayout) view.findViewById(R.id.hotPromo);
        hotPromo.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), DetailHotPromoActivity.class));
                a.finish();
            }
        });
        return view;
    }

}
