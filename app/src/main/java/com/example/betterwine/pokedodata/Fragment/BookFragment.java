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
import com.example.betterwine.pokedodata.Activity.BookActivity;
import com.example.betterwine.pokedodata.Activity.BookDetailActivity;
import com.example.betterwine.pokedodata.Activity.DataActivity;
import com.example.betterwine.pokedodata.Adapter.MovieAdapter;
import com.example.betterwine.pokedodata.Adapter.MusicAdaper;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Book;
import com.example.betterwine.pokedodata.Model.Movie;
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
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookFragment extends Fragment {

    @BindView(R.id.music_list)
    RecyclerView musicList;
    @BindView(R.id.refresh)
    RefreshLayout refreshLayout;
    Unbinder unbinder;

    private int start = 0;
    private ArrayList<douban> mList = new ArrayList<>();
    private MovieAdapter musicAdaper;
    private GridLayoutManager manager;


    public static BookFragment newInstance(String Title) {

        Bundle args = new Bundle();
        args.putString("title", Title);

        BookFragment fragment=new BookFragment();
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

        manager = new GridLayoutManager(getActivity(),
                3);
        musicList.setLayoutManager(manager);
        musicAdaper = new MovieAdapter(getActivity(), mList);
        musicList.setAdapter(musicAdaper);

        musicList.addOnItemTouchListener(new RecyclerViewItemTouchListener(musicList, new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=musicList.getChildAdapterPosition(view);
                Intent i=new Intent(getActivity(), BookDetailActivity.class);
                i.putExtra("id",mList.get(position).getId());
                startActivity(i);
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
        getBook(start);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                start += 10;
                getBook(start);
                refreshlayout.finishLoadmore(2000);
            }
        });
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));

        return v;
    }

    public void getBook(int start)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/book/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String tag=getArguments().getString("title");

        retrofitInterface.getBook(tag,start,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Book book) {
                        for (int i=0;i<book.getBooks().size();i++)
                        {
                            douban douban=new douban();
                            douban.setId(book.getBooks().get(i).getId());
                            douban.setImg(book.getBooks().get(i).getImage());
                            douban.setStr(book.getBooks().get(i).getTitle());
                            douban.setAlt("评分："+book.getBooks().get(i).getRating().getAverage());
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
