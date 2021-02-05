package com.example.movietmdb;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;
    public static String BaseUrl = "https://api.themoviedb.org/";
    public static String AppId = "55957fcf3ba81b137f8fc01ac5a31fb5";
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Context that = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        //mRecyclerView.setHasFixedSize(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<MovieDataCollection> call = service.getNowPlaying(AppId,"en-US",null);

        call.enqueue(new Callback<MovieDataCollection>() {
                         @RequiresApi(api = Build.VERSION_CODES.O)
                         @Override
                         public void onResponse(@NonNull Call<MovieDataCollection> call, @NonNull Response<MovieDataCollection> response) {

                             if (response.code() == 200) {
                                 MovieDataCollection movieResponse = response.body();
                                 assert movieResponse != null;
                                 //mRecyclerView.setLayoutManager(new LinearLayoutManager(that));
                                 mRecyclerView.setLayoutManager(new GridLayoutManager(that, 2, LinearLayoutManager.VERTICAL, false));
                                 mRecyclerView.setHasFixedSize(true);
                                 adapter = new RecyclerViewAdapter(that, movieResponse);
                                 mRecyclerView.setAdapter(adapter);

                                 id = movieResponse.results.get(0).id;

                             }
                         }

                             @Override
                             public void onFailure (Call < MovieDataCollection > call, Throwable t){
                                 Log.d("failure", t.getMessage());
                             }

    });


        Call<MovieDataCollection> call2 = service.getDetailsedScreen(id,AppId);

        call2.enqueue(new Callback<MovieDataCollection>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(@NonNull Call<MovieDataCollection> call, @NonNull Response<MovieDataCollection> response) {

                if (response.code() == 200) {
                    MovieDataCollection movieResponse = response.body();
                    assert movieResponse != null;

                }
            }

            @Override
            public void onFailure (Call < MovieDataCollection > call, Throwable t){
                Log.d("failure", t.getMessage());
            }

        });

    }
}