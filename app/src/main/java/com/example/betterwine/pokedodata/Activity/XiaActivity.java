package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.Xia;
import com.example.betterwine.pokedodata.Model.category;
import com.example.betterwine.pokedodata.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import com.example.betterwine.pokedodata.Model.raw;

public class XiaActivity extends AppCompatActivity {

    @BindView(R.id.xia)
    WebView xiakan;
    @BindView(R.id.refresh)
    FloatingActionButton refresh;
    @BindView(R.id.xia_title)
    TextView XiaTitle;
    @BindView(R.id.xia_Toolbar)
    Toolbar XiaToolbar;

    private String sHeada;
    private String Id;
    private String Xia[]={"wow","apps","imrich","diediedie","thinking"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xia);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);

        xiakan.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        initData();
        initView();

        Random random = new Random();
        int num = random.nextInt(Xia.length);
        getId(Xia[num]);

    }

    void initView()
    {
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(Xia.length);
                getId(Xia[num]);            }
        });

        setSupportActionBar(XiaToolbar);
        XiaToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle("瞎看");
    }
    void initData()
    {
        sHeada=   "<html><head><meta name=\"viewport\" content=\"width=device-width, " +
                "initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes\" />"+
                "<style>img{max-width:100% !important;height:auto !important;}</style>"
                +"<style>body{max-width:100% !important;}</style>"+"</head><body>";
    }

    public void getId(String xia)
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/xiandu/category/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        retrofitInterface.getId(xia)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<category>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(category category) {
                        int i=category.getResults().size();
                        Random random = new Random();
                        int num = random.nextInt(i);
                        String aaa=category.getResults().get(num).getId();
                        Id=aaa;
                        int num1 = random.nextInt(20);
                        requestXia(Id,num1,sHeada);
                    }
                });
    }

    public void requestXia(String id, final int count,final String sHead)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/xiandu/data/id/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        retrofitInterface.getXia(id,20,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<com.example.betterwine.pokedodata.Model.Xia>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Xia xia) {
                        raw a=new Gson().fromJson(xia.getResults().get(count).getRaw(),raw.class);
                        String text=a.getSummary().getContent();
                        String text2=text.replace("\\n","<br/>");
                        String text3=text2.replace("\\xa0","");
                        xiakan.loadDataWithBaseURL(null,sHead+text3,"text/html","utf-8",null);

                        XiaTitle.setText(a.getTitle());
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

    public static String subZeroAndDot(String str) {
        String regex1="summary(.*?)True";
        Pattern p1=Pattern.compile(regex1);
        Matcher m1=p1.matcher(str);
        while(m1.find()){
            String regex="(?<=\\{)(.+?)(?=\\})";
            Pattern p=Pattern.compile(regex);
            Matcher m=p.matcher(m1.group(1));
            while(m.find()){
                String regex2="content': '(.*?)'";
                Pattern p2=Pattern.compile(regex2);
                Matcher m2=p2.matcher(m.group(1));
                while (m2.find())
                {
                    Pattern p3 = Pattern.compile("\\s*|\t|\r|\n");
                    Matcher m3 = p3.matcher(m2.group(1));
                    String text = m3.replaceAll("");
                    return text;
                }
            }
        }
        return "";
    }
}
