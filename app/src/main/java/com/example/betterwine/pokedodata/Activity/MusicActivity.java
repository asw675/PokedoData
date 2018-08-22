package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.betterwine.pokedodata.Fragment.MusicFragment;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.douban;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusicActivity extends AppCompatActivity {
    @BindView(R.id.douban_Toolbar)
    Toolbar doubanToolbar;
    @BindView(R.id.type)
    TabLayout type;
    @BindView(R.id.list)
    ViewPager list;

    private ArrayList<String> mFragmentPair=new ArrayList<>();
    private int start=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        ButterKnife.bind(this);
        type.setupWithViewPager(list);
        initData();
        initView();
    }
    public void initData()
    {
        String[] title={"最热","最新","流行","摇滚"};
        for(int i=0;i<title.length;i++)
        {
        mFragmentPair.add(title[i]);
        }
    }
    public void initView()
    {
        setSupportActionBar(doubanToolbar);
        doubanToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle("音乐");
        FragmentManager fragmentManager=getSupportFragmentManager();
        list.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return MusicFragment.newInstance(mFragmentPair.get(i));
            }

            @Override
            public int getCount() {
                return mFragmentPair.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentPair.get(position);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
