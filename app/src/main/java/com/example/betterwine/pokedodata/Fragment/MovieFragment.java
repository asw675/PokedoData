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

import com.example.betterwine.pokedodata.Activity.DataActivity;
import com.example.betterwine.pokedodata.Activity.MovieDetailActivity;
import com.example.betterwine.pokedodata.Adapter.MovieAdapter;
import com.example.betterwine.pokedodata.Adapter.MusicAdaper;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Movie;
import com.example.betterwine.pokedodata.Model.Music;
import com.example.betterwine.pokedodata.Model.douban;
import com.example.betterwine.pokedodata.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieFragment extends Fragment {
    @BindView(R.id.music_list)
    RecyclerView musicList;
    @BindView(R.id.refresh)
    RefreshLayout refreshLayout;
    Unbinder unbinder;

    private int start=0;
    private ArrayList<douban> mList=new ArrayList<>();
    private MovieAdapter movieAdapter;
    private GridLayoutManager manager;
    private Realm realm ;

    public static MovieFragment newInstance(String Title) {

        Bundle args = new Bundle();
        args.putString("title",Title);

        MovieFragment fragment = new MovieFragment();
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
        movieAdapter=new MovieAdapter(getActivity(),mList);
        musicList.setAdapter(movieAdapter);

        musicList.addOnItemTouchListener(new com.example.betterwine.locateddemo.RecyclerViewItemTouchListener(musicList, new com.example.betterwine.locateddemo.RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=musicList.getChildAdapterPosition(view);
                Intent i=new Intent(getActivity(), MovieDetailActivity.class);
                i.putExtra("id",mList.get(position).getId());
                startActivity(i);
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
        if(getArguments().getString("title").equals("动漫"))
        {
            getAnimate(start);
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    start+=10;
                    getAnimate(start);
                    refreshlayout.finishLoadmore(2000);
                }
            });
        }
        else {
        getMovie(start);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                start+=10;
                getMovie(start);
                refreshlayout.finishLoadmore(2000);
            }
        });}
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getAnimate(int start)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String tag=getArguments().getString("title");

        retrofitInterface.getAnimate(tag,start,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Movie movie) {
                        for(int i=0;i<movie.getSubjects().size();i++)
                        {
                            douban douban=new douban();
                            douban.setStr(movie.getSubjects().get(i).getTitle());
                            douban.setAlt("评分："+movie.getSubjects().get(i).getRating().getAverage());
                            douban.setImg(movie.getSubjects().get(i).getImages().getLarge());
                            douban.setId(movie.getSubjects().get(i).getId());
                            mList.add(douban);
                        }
                        movieAdapter.notifyDataSetChanged();
                    }
                });
    }
    public void getMovie(int start)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String tag=getArguments().getString("title");

        retrofitInterface.getMovie(tag,start,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(),"好痛",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Movie movie) {
                        Toast.makeText(getActivity(),"舒服",Toast.LENGTH_SHORT).show();
                        for(int i=0;i<movie.getSubjects().size();i++)
                        {
                            douban douban=new douban();
                            douban.setStr(movie.getSubjects().get(i).getTitle());
                            douban.setAlt("评分："+movie.getSubjects().get(i).getRating().getAverage());
                            douban.setImg(movie.getSubjects().get(i).getImages().getLarge());
                            douban.setId(movie.getSubjects().get(i).getId());
                            mList.add(douban);
                        }
                        movieAdapter.notifyDataSetChanged();
                    }
                });
    }
}
