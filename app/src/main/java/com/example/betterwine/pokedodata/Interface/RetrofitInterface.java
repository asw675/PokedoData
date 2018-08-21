package com.example.betterwine.pokedodata.Interface;

import com.example.betterwine.pokedodata.Model.News;
import com.example.betterwine.pokedodata.Model.Weather;
import com.example.betterwine.pokedodata.Model.Xia;
import com.example.betterwine.pokedodata.Model.category;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitInterface {

    @GET("/Weather/Query")
    Observable<Weather> getWeather(
            @Query("key") String key,
            @Query("cityname") String cityname
    );

    @GET("{a}/count/{count}/page/{page}")
    Observable<Xia> getXia(
            @Path("a") String a,
            @Path("count") int count,
            @Path("page") int page
    );

    @GET("{category}")
    Observable<category> getId(
            @Path("category") String category
    );

    @GET("/journalismApi")
    Observable<News> getNews(
    );
}
