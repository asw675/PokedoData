package com.example.betterwine.pokedodata.Interface;

import com.example.betterwine.pokedodata.Model.Book;
import com.example.betterwine.pokedodata.Model.BookDetail;
import com.example.betterwine.pokedodata.Model.Movie;
import com.example.betterwine.pokedodata.Model.MovieDetail;
import com.example.betterwine.pokedodata.Model.Music;
import com.example.betterwine.pokedodata.Model.News;
import com.example.betterwine.pokedodata.Model.Picture;
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

    @GET("search")
    Observable<Music> getMusic(
        @Query("tag") String tag,
        @Query("start") int start,
        @Query("count") int count
    );

    @GET("{qq}")
    Observable<Movie> getMovie(
            @Path("qq") String qq,
            @Query("start") int start,
            @Query("count") int count
    );

    @GET("search")
    Observable<Movie> getAnimate(
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count
    );

    @GET("{id}")
    Observable<MovieDetail> getMovieDetail(
            @Path("id") String id
    );

    @GET("search")
    Observable<Book> getBook(
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count
    );

    @GET("{id}")
    Observable<BookDetail> getBookDetail(
            @Path("id") String id
    );

    @GET("/api")
    Observable<Picture> getPicture(
            @Query("key") String key,
            @Query("page") int page
    );

    @GET("/api")
    Observable<Picture> getSearchPicture(
            @Query("key") String key,
            @Query("q") String q,
            @Query("page") int page
    );


}
