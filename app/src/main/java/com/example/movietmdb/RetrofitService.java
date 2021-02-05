package com.example.movietmdb;

import retrofit2.Call;

import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET("3/movie/now_playing?")
    Call<MovieDataCollection> getNowPlaying(@Query("api_key")String app_id,@Query("original_language") String language,@Query("page") Integer pagenumber);
    @GET("3/movie/{id}?")
    Call<MovieDataCollection> getDetailsedScreen(@Path("id")int movieId,@Query("api_key")String app_id);
}
