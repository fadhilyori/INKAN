package com.apps.inkan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.inkan.EditProfilActivity;
import com.apps.inkan.Model.Artikel;
import com.apps.inkan.R;

import java.util.List;

/**
 * Created by user on 13/01/2018.
 */

public class DataArtikelAdapter extends RecyclerView.Adapter<DataArtikelAdapter.MyViewHolder> {
    private Artikel list_data_artikel;
    private Context mContext;
    List<Artikel> mArtikelList;

    public DataArtikelAdapter(Context mContext, Artikel list_data_pembangunan) {
        this.mContext = mContext;
        this.list_data_artikel = list_data_pembangunan;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pengetahuan, parent, false);
        DataArtikelAdapter.MyViewHolder mViewHolder = new DataArtikelAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(DataArtikelAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewJudul.setText("Username = " + mArtikelList.get(position).getJudul());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditProfilActivity.class);
                mIntent.putExtra("Judul", mArtikelList.get(position).getJudul());
                mIntent.putExtra("Foto", mArtikelList.get(position).getPicture());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArtikelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewJudul;
        public ImageView mImageViewPicture;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewJudul = (TextView) itemView.findViewById(R.id.judulartikel);
            mImageViewPicture = (ImageView) itemView.findViewById(R.id.gambarartikel);
        }
    }
}
