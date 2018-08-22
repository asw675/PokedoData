package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.betterwine.pokedodata.Fragment.MovieFragment;
import com.example.betterwine.pokedodata.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.douban_Toolbar)
    Toolbar doubanToolbar;
    @BindView(R.id.type)
    TabLayout type;
    @BindView(R.id.list)
    ViewPager list;

    private ArrayList<String> mFragmentPair=new ArrayList<>();
    private String[] title={"热映","即将上映","Top250","动画电影"};

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

        for(int i=0;i<title.length;i++)
        {
            switch (i)
            {
                case 0:mFragmentPair.add("in_theaters");break;
                case 1:mFragmentPair.add("coming_soon");break;
                case 2:mFragmentPair.add("top250");break;
                case 3:mFragmentPair.add("动漫");break;
            }

        }
    }
    public void initView()
    {
        setSupportActionBar(doubanToolbar);
        doubanToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle("电影");
        FragmentManager fragmentManager=getSupportFragmentManager();
        list.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return MovieFragment.newInstance(mFragmentPair.get(i));
            }

            @Override
            public int getCount() {
                return mFragmentPair.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
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
