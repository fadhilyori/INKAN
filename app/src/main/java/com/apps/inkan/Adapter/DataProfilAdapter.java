package com.apps.inkan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.inkan.EditProfilActivity;
import com.apps.inkan.Model.User;
import com.apps.inkan.Model.UserModel;
import com.apps.inkan.R;

import java.util.List;

/**
 * Created by user on 12/01/2018.
 */

public class DataProfilAdapter extends RecyclerView.Adapter<DataProfilAdapter.MyViewHolder>{
    List<User> mUserList;

    public DataProfilAdapter(List <User> UserList) {
        mUserList = UserList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_profile, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewUsername.setText("Username = " + mUserList.get(position).getUsername());
        holder.mTextViewEmail.setText("Email = " + mUserList.get(position).getEmail());
        holder.mTextViewTelp.setText("Telp = " + mUserList.get(position).getPhone_number());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditProfilActivity.class);
                mIntent.putExtra("Username", mUserList.get(position).getUsername());
                mIntent.putExtra("Email", mUserList.get(position).getEmail());
                mIntent.putExtra("Telp", mUserList.get(position).getPhone_number());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewUsername, mTextViewEmail, mTextViewTelp, mTextViewAlamat;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            mTextViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            mTextViewAlamat = (TextView) itemView.findViewById(R.id.tvAlamat);
            mTextViewTelp = (TextView) itemView.findViewById(R.id.tvTelp);
        }
    }
}
