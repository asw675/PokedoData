package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

    @BindView(R.id.tourism_recy)
    RecyclerView tourismRecy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        ButterKnife.bind(this);

        NewsThread newsThread=new NewsThread("http://www.mafengwo.cn/gonglve/");
        newsThread.start();
        try {
            newsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mList=newsThread.List;
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
}
