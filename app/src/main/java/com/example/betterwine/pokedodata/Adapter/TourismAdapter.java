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
import com.example.betterwine.pokedodata.Model.tourism;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourismAdapter extends RecyclerView.Adapter<TourismAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<tourism> mList = new ArrayList<>();

    public TourismAdapter(Context context, ArrayList<tourism> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_tourism, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(i).getImg()).asBitmap().into(viewHolder.tourismImg);
        viewHolder.tourismTitle.setText(mList.get(i).getTitle());
        viewHolder.tourismSummary.setText(mList.get(i).getSummary());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tourism_title)
        TextView tourismTitle;
        @BindView(R.id.tourism_summary)
        TextView tourismSummary;
        @BindView(R.id.tourism_img)
        ImageView tourismImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
