package com.apps.inkan;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;



/**
 * A simple {@link Fragment} subclass.
 */
public class PengaturanFragment extends android.support.v4.app.Fragment {
    LinearLayout tentang;
    AppCompatActivity a = new AppCompatActivity();

    public PengaturanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pengaturan, container, false);

        tentang = (LinearLayout) view.findViewById(R.id.tentang);
        tentang.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                startActivity(new Intent(getActivity().getApplication(), TentangActivity.class));
                a.finish();
            }
        });
        return view;
    }

}


