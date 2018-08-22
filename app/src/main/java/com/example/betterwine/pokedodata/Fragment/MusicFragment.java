package com.example.betterwine.pokedodata.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.betterwine.locateddemo.RecyclerViewItemTouchListener;
import com.example.betterwine.pokedodata.Activity.DataActivity;
import com.example.betterwine.pokedodata.Activity.MusicActivity;
import com.example.betterwine.pokedodata.Adapter.MusicAdaper;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Music;
import com.example.betterwine.pokedodata.Model.douban;
import com.example.betterwine.pokedodata.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MusicFragment extends Fragment {

    @BindView(R.id.music_list)
    RecyclerView musicList;
    @BindView(R.id.refresh)
    RefreshLayout refreshLayout;
    Unbinder unbinder;

    private int start=0;
    private ArrayList<douban> mList=new ArrayList<>();
    private MusicAdaper musicAdaper;
    private GridLayoutManager manager;


    public static MusicFragment newInstance(String Title) {

        Bundle args = new Bundle();
        args.putString("title",Title);

        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music, container, false);
        unbinder = ButterKnife.bind(this, v);

        manager=new GridLayoutManager(getActivity(),3);
        musicList.setLayoutManager(manager);
        musicAdaper =new MusicAdaper(getActivity(),mList);
        musicList.setAdapter(musicAdaper);

        musicList.addOnItemTouchListener(new RecyclerViewItemTouchListener(musicList, new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=musicList.getChildAdapterPosition(view);
                Intent i=new Intent(getActivity(), DataActivity.class);
                i.putExtra("url",mList.get(position).getDataUrl());
                startActivity(i);
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
        getMusic(start);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                start+=10;
                getMusic(start);
                refreshlayout.finishLoadmore(2000);
            }
        });
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));

        return v;
    }

    public void getMusic(int start)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/music/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String tag=getArguments().getString("title");

        retrofitInterface.getMusic(tag,start,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Music>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Music music) {
                        for(int i=0;i<music.getMusics().size();i++)
                        {
                                douban douban=new douban();
                                douban.setStr(music.getMusics().get(i).getTitle());
                                douban.setImg(music.getMusics().get(i).getImage());
                                douban.setDataUrl(music.getMusics().get(i).getMobile_link());
                                mList.add(douban);
                        }
                        musicAdaper.notifyDataSetChanged();
                    }
                });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
