package com.example.betterwine.pokedodata.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.betterwine.locateddemo.RecyclerViewItemTouchListener;
import com.example.betterwine.pokedodata.Adapter.TourismAdapter;
import com.example.betterwine.pokedodata.Model.tourism;
import com.example.betterwine.pokedodata.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourismActivity extends AppCompatActivity {
    private ArrayList<tourism> mList=new ArrayList<>();
    private LinearLayoutManager manager;
    private TourismAdapter tourismAdapter;

    @BindView(R.id.tourism_recy)
    RecyclerView tourismRecy;
    @BindView(R.id.douban_Toolbar)
    Toolbar doubanToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        ButterKnife.bind(this);

        initData();
        initView();
    }
    public void initData()
    {
        NewsThread newsThread=new NewsThread("http://www.mafengwo.cn/gonglve/");
        newsThread.start();
        try {
            newsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mList=newsThread.List;
    }
    public void initView()
    {
        setSupportActionBar(doubanToolbar);
        doubanToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle("旅游");
        manager=new LinearLayoutManager(TourismActivity.this);
        tourismRecy.setLayoutManager(manager);
        tourismAdapter=new TourismAdapter(TourismActivity.this,mList);
        tourismRecy.setAdapter(tourismAdapter);
        tourismRecy.addOnItemTouchListener(new RecyclerViewItemTouchListener(tourismRecy, new RecyclerViewItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position=tourismRecy.getChildAdapterPosition(view);
                Intent i=new Intent(TourismActivity.this,DataActivity.class);
                i.putExtra("url",mList.get(position).getUrl());
                startActivity(i);
            }

            @Override
            public void onItemLongClick(View view) {

            }
        }));
    }

    public class NewsThread extends Thread{
        private String NewsText;
        private String url;
        private ArrayList<tourism> List=new ArrayList<>();

        public NewsThread(String url)
        {
            this.url=url;
        }

        @Override
        public void run() {
            super.run();
            try{
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("div.feed-item").select("._j_feed_item");
                for (Element link : elements) {
                    tourism tourism=new tourism();
                    tourism.setImg(link.select("img").get(0).attr("src"));
                    tourism.setSummary(link.select("div.info").text());
                    tourism.setTitle(link.select("div.title").text());
                    tourism.setUrl(link.select("a").attr("href"));
                    List.add(tourism);
                }
                for(int i=0;i<mList.size();i++)
                {
                    Log.i("tag==",List.get(i).getTitle());
                    Log.i("tag==",List.get(i).getSummary());
                    Log.i("tag==",List.get(i).getImg());
                    Log.i("tag==",List.get(i).getUrl());
                }
                NewsText=doc.html();
            }catch(Exception e) {
                Log.i("mytag", e.toString());
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
