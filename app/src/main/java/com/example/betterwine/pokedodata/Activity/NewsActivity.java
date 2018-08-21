package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.View;

import com.example.betterwine.pokedodata.Adapter.NewsAdapter;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.News;
import com.example.betterwine.pokedodata.Model.NewsTitle;
import com.example.betterwine.pokedodata.Model.mainlist;
import com.example.betterwine.pokedodata.R;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsActivity extends AppCompatActivity{

    @BindView(R.id.news)
    RecyclerView mRecy;

    private ArrayList<String> mList=new ArrayList<>();
    private ArrayList<NewsTitle> mNews=new ArrayList<>();
    private String[] Title1=new String[7];
    private String[] Title2=new String[7];
    private String[] Text=new String[7];
    private NewsAdapter newsAdapter;
    private RecyclerViewExpandableItemManager expMgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        initData();
        getNews();
        initView();
    }

    void initData()
    {

    }
    public void initView()
    {
        expMgr = new RecyclerViewExpandableItemManager(null);
        LinearLayoutManager manager=new LinearLayoutManager(NewsActivity.this);
        mRecy.setLayoutManager(manager);
        newsAdapter=new NewsAdapter(mNews,NewsActivity.this);
        mRecy.setAdapter(expMgr.createWrappedAdapter(newsAdapter));
        ((SimpleItemAnimator) mRecy.getItemAnimator()).setSupportsChangeAnimations(false);
        expMgr.attachRecyclerView(mRecy);
    }

    public void getNews()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        retrofitInterface.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news)
                    {
//                        Title.clear();
                        Random random = new Random();
                        int k = random.nextInt(8);
                        Title1[0] = news.getData().getAuto().get(k).getTitle();
                        Title1[1] = news.getData().getTech().get(k).getTitle();
                        Title1[2] = news.getData().getMoney().get(k).getTitle();
                        Title1[3] = news.getData().getSports().get(k).getTitle();
                        Title1[4] = news.getData().getDy().get(k).getTitle();
                        Title1[5] = news.getData().getWar().get(k).getTitle();
                        Title1[6] = news.getData().getEnt().get(k).getTitle();
                        Title2[0] = news.getData().getAuto().get(k).getPicInfo().get(0).getUrl();
                        Title2[1] = news.getData().getTech().get(k).getPicInfo().get(0).getUrl();
                        Title2[2] = news.getData().getMoney().get(k).getPicInfo().get(0).getUrl();
                        Title2[3] = news.getData().getSports().get(k).getPicInfo().get(0).getUrl();
                        Title2[4] = news.getData().getDy().get(k).getPicInfo().get(0).getUrl();
                        Title2[5] = news.getData().getWar().get(k).getPicInfo().get(0).getUrl();
                        Title2[6] = news.getData().getEnt().get(k).getPicInfo().get(0).getUrl();
                        try{
                        Text[0]=setNewsText(news.getData().getAuto().get(k).getLink());
                        Text[1]=setNewsText(news.getData().getTech().get(k).getLink());
                            Text[2]=setNewsText(news.getData().getMoney().get(k).getLink());
                            Text[3]=setNewsText(news.getData().getSports().get(k).getLink());
                            Text[4]=setNewsText(news.getData().getDy().get(k).getLink());
                            Text[5]=setNewsText(news.getData().getWar().get(k).getLink());
                            Text[6]=setNewsText(news.getData().getEnt().get(k).getLink());
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String[] Title3={"auto","tech","money","sports","dy","war","ent"};
                        for (int i = 0; i < 7; i++) {
                            Log.i("title1:", Title1[i]);
                            Log.i("title2", Title2[i]);
                            NewsTitle newsTitle = new NewsTitle();
                            newsTitle.setTitle(Title1[i]);
                            newsTitle.setIcon(Title2[i]);
                            newsTitle.setType(Title3[i]);
                            newsTitle.setNewsText(Text[i]);
                            mNews.add(newsTitle);
                        }
                        newsAdapter.notifythis();
                    }

                });
    }

    public String setNewsText(final String url) throws InterruptedException
    {
       NewsThread newsThread=new NewsThread(url);
       newsThread.start();
       newsThread.join();
       return newsThread.NewsText;
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
                Elements elements = doc.getElementsByTag("p");
                //实例化stringbuffer
                StringBuffer buffer =new StringBuffer();
                for (Element link : elements) {
                    buffer.append(link.text().trim()+'\n');
                }
                NewsText=buffer.toString();
            }catch(Exception e) {
                Log.i("mytag", e.toString());
            }
        }
    }

    public int[] getSize(int[] a)
    {
        int i=0;
        int b[]=new int[10];
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        while(i<10) {
            Random random = new Random();
            int num = random.nextInt(a.length);
            if (!hashMap.containsKey(a[num])) {
                b[i] = a[num];
                hashMap.put(a[num],a[num]);
                i++;
            }
        }
        return b;
    }
}
