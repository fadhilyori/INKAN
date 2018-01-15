package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PengetahuanFragment extends android.support.v4.app.Fragment {
    TextView detailArtikel;
    AppCompatActivity a = new AppCompatActivity();

    public PengetahuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pengetahuan, container, false);

        detailArtikel = (TextView) view.findViewById(R.id.detailArtikel);
        detailArtikel.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), DetailPengetahuanActivity.class));
                a.finish();
            }
        });
        return view;
    }

}
