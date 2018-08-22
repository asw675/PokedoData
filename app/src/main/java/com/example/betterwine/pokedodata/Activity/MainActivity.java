package com.example.betterwine.pokedodata.Activity;

import android.Manifest;
import android.content.Intent;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.betterwine.locateddemo.RecyclerViewItemTouchListener;
import com.example.betterwine.pokedodata.Adapter.ListAdapter;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Weather;
import com.example.betterwine.pokedodata.Model.Xia;
import com.example.betterwine.pokedodata.Model.mainlist;
import com.example.betterwine.pokedodata.PermissionsUtils;
import com.example.betterwine.pokedodata.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sheshidu)
    TextView sheshidu;
    @BindView(R.id.weather)
    TextView mWeather;
    @BindView(R.id.weather_other)
    TextView WeatherOther;
    @BindView(R.id.main_recy)
    RecyclerView mRecy;

    private String cityname;
    private ArrayList<mainlist> mList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);

        cityname=getIntent().getStringExtra("city");
        RequestWeather(cityname);

        initData();
        initView();

    }

    void initData() {
        Integer funcIcon[] = {R.mipmap.news, R.mipmap.wenzi, R.mipmap.data, R.mipmap.lvyou,
                R.mipmap.xuexi, R.mipmap.yule, R.mipmap.xiakan, R.mipmap.other};
        String funcName[] = {"新闻", "文字", "音乐", "旅游", "学习", "电影", "瞎看", "其他"};

        for (int i = 0; i < 8; i++)
        {
            mainlist mainlist=new mainlist();
            mainlist.setImg(funcIcon[i]);
            mainlist.setListname(funcName[i]);
            mList.add(mainlist);
        }
    }

    void initView()
    {
        GridLayoutManager manager=new GridLayoutManager(MainActivity.this,2);
        mRecy.setLayoutManager(manager);
        ListAdapter listAdapter=new ListAdapter(MainActivity.this,mList);
        mRecy.setAdapter(listAdapter);

        mRecy.addOnItemTouchListener(new RecyclerViewItemTouchListener(mRecy,
                new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=mRecy.getChildAdapterPosition(view);
                if(mList.get(position).getListname().equals("新闻"))
                {
                    startActivity(new Intent(MainActivity.this,NewsActivity.class));
                }
                if (mList.get(position).getListname().equals("瞎看"))
                {
                    startActivity(new Intent(MainActivity.this,XiaActivity.class));
                }
                if(mList.get(position).getListname().equals("旅游"))
                {
                    startActivity(new Intent(MainActivity.this,TourismActivity.class));
                }
                if(mList.get(position).getListname().equals("音乐"))
                {
                    startActivity(new Intent(MainActivity.this,MusicActivity.class));
                }
                if(mList.get(position).getListname().equals("电影"))
                {
                    startActivity(new Intent(MainActivity.this,MovieActivity.class));
                }
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
    }


    public void RequestWeather(String cityname) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.avatardata.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        retrofitInterface.getWeather("b2fece65d8d04878b1e3f5921d3e824a",cityname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Weather weather) {
                        sheshidu.setText(weather.getResult().getRealtime().getWeather().getTemperature()+"°");
                        mWeather.setText(weather.getResult().getRealtime().getWeather().getInfo());
                        StringBuilder other=new StringBuilder();
                        other.append(weather.getResult().getRealtime().getCity_name()+"   ");
                        other.append(weather.getResult().getRealtime().getWind().getDirect()+" ");
                        other.append(weather.getResult().getRealtime().getWind().getPower()+"    ");
                        other.append(weather.getResult().getPm25().getPm25().getDes());
                        WeatherOther.setText(other);
                    }
                });
    }

}
