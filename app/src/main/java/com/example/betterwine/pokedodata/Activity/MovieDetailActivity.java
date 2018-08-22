package com.example.betterwine.pokedodata.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.betterwine.pokedodata.Interface.RetrofitInterface;
import com.example.betterwine.pokedodata.Model.MovieDetail;
import com.example.betterwine.pokedodata.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieDetailActivity extends AppCompatActivity {

    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_alt)
    TextView movieAlt;
    @BindView(R.id.movie_time)
    TextView movieTime;
    @BindView(R.id.movie_img)
    ImageView movieImg;
    @BindView(R.id.cardView2)
    CardView cardView2;
    @BindView(R.id.movie_tag)
    TextView movieTag;
    @BindView(R.id.movie_summary)
    TextView movieSummary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        getMovieDetail();
    }

    public void getMovieDetail()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        String id=getIntent().getStringExtra("id");

        retrofitInterface.getMovieDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MovieDetailActivity.this,"好痛",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MovieDetail movieDetail) {
                        Toast.makeText(MovieDetailActivity.this,"舒服",Toast.LENGTH_SHORT).show();
                        movieTitle.setText(movieDetail.getTitle());
                        movieAlt.setText("评分："+movieDetail.getRating().getAverage());
                        String str="";
                        str+=movieDetail.getAttrs().getMovie_duration();
                        str+="\n";
                        str+=movieDetail.getAttrs().getMovie_type();
                        str+="\n";
                        str+=movieDetail.getAttrs().getDirector();
                        str+="(导演)/";
                        for(int i=0;i<3;i++)
                        {
                            str+=movieDetail.getAttrs().getCast().get(i);
                            str+="/";
                        }
                        str+="\n";
                        str+=movieDetail.getAttrs().getPubdate();
                        str+="上映";
                        movieTime.setText(str);
                        StringBuffer tag=new StringBuffer();
                        for(int i=0;i<movieDetail.getTags().size();i++)
                        {
                            tag.append(movieDetail.getTags().get(i).getName()+"     ");
                        }
                        movieTag.setText(tag.toString());
                        movieSummary.setText(movieDetail.getSummary());
                        Glide.with(MovieDetailActivity.this).load(movieDetail.getImage()).asBitmap().into(movieImg);
                    }
                });
    }
}
