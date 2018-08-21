package com.example.betterwine.pokedodata.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.Model.News;
import com.example.betterwine.pokedodata.Model.NewsTitle;
import com.example.betterwine.pokedodata.Model.mainlist;
import com.example.betterwine.pokedodata.R;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends AbstractExpandableItemAdapter<NewsAdapter.MyGroupViewHolder, NewsAdapter.MyChildViewHolder> {

    static class MyGroupViewHolder extends AbstractExpandableItemViewHolder {
        @BindView(R.id.newsTitle)
        TextView newsTitle;
        @BindView(R.id.newsText)
        TextView newsText;
        @BindView(R.id.newsImg)
        ImageView NewsImg;

        public MyGroupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    static class MyChildViewHolder extends AbstractExpandableItemViewHolder {
        @BindView(R.id.news_child)
        TextView newsChild;

        public MyChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private ArrayList<String> mList=new ArrayList<>();
    private ArrayList<NewsTitle> mNews=new ArrayList<>();
    private Context mContext;

    public NewsAdapter( ArrayList<NewsTitle> news,Context context)
    {
        setHasStableIds(true);
        this.mNews=news;
        this.mContext=context;
    }

    public void notifythis()
    {
        this.notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return mNews.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public MyGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group,parent,false);
        return new MyGroupViewHolder(v);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_child,parent,false);
        return new MyChildViewHolder(v);
    }

    @Override
    public void onBindGroupViewHolder(MyGroupViewHolder holder, int groupPosition, int viewType) {
        holder.newsTitle.setText(mNews.get(groupPosition).getType());
        holder.newsText.setText(mNews.get(groupPosition).getTitle());
        Glide.with(mContext).load(mNews.get(groupPosition).getIcon()).asBitmap().into(holder.NewsImg);
    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder holder, int groupPosition, int childPosition, int viewType) {
        holder.newsChild.setText(mNews.get(groupPosition).getNewsText());
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(MyGroupViewHolder holder, int groupPosition, int x, int y, boolean expand) {
        return true;
    }
}
