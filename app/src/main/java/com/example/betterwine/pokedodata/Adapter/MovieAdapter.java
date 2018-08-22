package com.example.betterwine.pokedodata.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.Model.douban;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<douban> mList = new ArrayList<>();

    public MovieAdapter(Context context, ArrayList<douban> list) {
        this.mContext = context;
        this.mList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(i).getImg()).asBitmap().into(viewHolder.movieImg);
        viewHolder.movieAlt.setText(mList.get(i).getAlt());
        viewHolder.movieName.setText(mList.get(i).getStr());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_img)
        ImageView movieImg;
        @BindView(R.id.movie_name)
        TextView movieName;
        @BindView(R.id.movie_alt)
        TextView movieAlt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
