package com.example.betterwine.pokedodata.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.betterwine.locateddemo.RecyclerViewItemTouchListener;
import com.example.betterwine.pokedodata.Adapter.PictureAdapter;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Picture;
import com.example.betterwine.pokedodata.R;
import com.example.betterwine.pokedodata.dialog.search_dialog;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PictureActivity extends AppCompatActivity {

    @BindView(R.id.picture)
    RecyclerView picture;
    @BindView(R.id.refresh_picture)
    RefreshLayout refreshLayout;
    @BindView(R.id.picture_Toolbar)
    Toolbar pictureToolbar;

    private StaggeredGridLayoutManager manager;
    private PictureAdapter pictureAdapter;
    private ArrayList<String> mList = new ArrayList<>();
    private int page = 1;
    private boolean flag=false;
    private String search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        setSupportActionBar(pictureToolbar);
        pictureToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle("看图");
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//防止上拉时ITEM跳动
        picture.setLayoutManager(manager);
        pictureAdapter = new PictureAdapter(PictureActivity.this, mList);
        picture.setAdapter(pictureAdapter);
        picture.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                manager.invalidateSpanAssignments();//去除顶部空白
            }
        });
        getPicture(page);
        if(!flag){
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page += 1;
                getPicture(page);
                refreshlayout.finishLoadmore(2000);
            }
        });}
        else {
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    page += 1;
                    searchPicture(search,page);
                    refreshlayout.finishLoadmore(2000);
                }
            });
        }
        refreshLayout.setRefreshFooter(new BallPulseFooter(PictureActivity.this).setSpinnerStyle(SpinnerStyle.Scale));

        picture.addOnItemTouchListener(new RecyclerViewItemTouchListener(picture, new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=picture.getChildAdapterPosition(view);
                Intent i=new Intent(PictureActivity.this,PictureDetailActivity.class);
                i.putExtra("url",mList.get(position));
                startActivity(i,
                        ActivityOptions.makeSceneTransitionAnimation(PictureActivity.this, view, "shareNames").toBundle());
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
    }

    public void getPicture(int start) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        retrofitInterface.getPicture("9900971-373c124b9f186086cf19098da", start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Picture>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(PictureActivity.this, "好痛", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Picture picture) {
                        Toast.makeText(PictureActivity.this, "舒服", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < picture.getHits().size(); i++) {
                            mList.add(picture.getHits().get(i).getLargeImageURL());
                        }
                        pictureAdapter.notifyDataSetChanged();
                    }
                });
    }

    public void searchPicture(String tag,int start)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        retrofitInterface.getSearchPicture("9900971-373c124b9f186086cf19098da",tag, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Picture>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(PictureActivity.this, "好痛", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Picture picture) {
                        Toast.makeText(PictureActivity.this, "舒服", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < picture.getHits().size(); i++) {
                            mList.add(picture.getHits().get(i).getLargeImageURL());
                        }
                        pictureAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        if (item.getItemId()==R.id.search)
        {
            search_dialog dialog=new search_dialog(PictureActivity.this, new search_dialog.PriorityListener() {
                @Override
                public void setActivityText(String string) {
                    page=1;
                    mList.clear();
                    searchPicture(string,page);
                    flag=true;
                    search=string;
                }
            });
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.picture_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
