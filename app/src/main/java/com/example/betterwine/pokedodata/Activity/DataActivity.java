package com.example.betterwine.pokedodata.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.betterwine.pokedodata.Model.tourism;
import com.example.betterwine.pokedodata.R;
import com.example.betterwine.pokedodata.Utils.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataActivity extends AppCompatActivity {
    @BindView(R.id.checkweb)
    WebView checkweb;

    private ArrayList<tourism> mList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);
        checkweb.getSettings().setJavaScriptEnabled(true);//启用js
        checkweb.getSettings().setBlockNetworkImage(false);//解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            checkweb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }


        String sHead=   "<html><head><meta name=\"viewport\" content=\"width=device-width, " +
                "initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes\" />"+
                "<style>img{max-width:100% !important;height:auto !important;}</style>"
                +"<style>body{max-width:100% !important;}</style>"+"</head><body>";

        NewsThread newsThread=new NewsThread("http://www.mafengwo.cn/gonglve/");
        newsThread.start();
        try {
            newsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String regex1="<p>([\\s\\S]*)</p>";
//        Pattern p1=Pattern.compile(regex1);
//        Matcher m1=p1.matcher(newsThread.NewsText);

        checkweb.loadDataWithBaseURL(null,newsThread.NewsText,"text/html","utf-8",null);
    }



    public class NewsThread extends Thread{
        private String NewsText;
        private String url;

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
                        mList.add(tourism);
                }
                for(int i=0;i<mList.size();i++)
                {
                    Log.i("tag==",mList.get(i).getTitle());
                    Log.i("tag==",mList.get(i).getSummary());
                    Log.i("tag==",mList.get(i).getImg());
                    Log.i("tag==",mList.get(i).getUrl());
                }
                NewsText=doc.html();
            }catch(Exception e) {
                Log.i("mytag", e.toString());
            }
        }
    }
}
