package com.example.betterwine.pokedodata.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.viewHolder> {

    private ArrayList<String> mList = new ArrayList<>();
    private Context mContext;

    public PictureAdapter(Context context, ArrayList<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.picture)
        ImageView picture;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_picture, viewGroup, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(i)).asBitmap().into(viewHolder.picture);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
