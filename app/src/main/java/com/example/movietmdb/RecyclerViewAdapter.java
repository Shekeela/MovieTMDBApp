package com.example.movietmdb;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {



    Context context;
    MovieDataCollection data;

    LayoutInflater inflater;  // 1.a

    public RecyclerViewAdapter(Context context, MovieDataCollection data) { // 3

        this.data = data;
        this.context = context;
        inflater= LayoutInflater.from(context);  //1.a
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("viewholder","oncreateViewholder entered");
        View view = inflater.inflate(R.layout.recycleritem,parent,false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {

        Picasso.with(context).load(data.results.get(position).getImageURL()).into(holder.recyclerViewitemMOvieImage);

        holder.recyclerViewitemMOvieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(context, DetailedScreen.class);
                go.putExtra("image",data.results.get(position).getImageURL());
                go.putExtra("languageid",data.results.get(position).language);
                go.putExtra("moviename",data.results.get(position).movieName);
                go.putExtra("overview",data.results.get(position).overview);
                go.putExtra("popularity",data.results.get(position).getPopularity());
                go.putExtra("releasedate",data.results.get(position).release_date);
                go.putExtra("votecount",data.results.get(position).getVote_count());
                go.putExtra("voteavaregare",data.results.get(position).getVote_average());
                context.startActivity(go);

            }
        });
    }

    @Override
    public int getItemCount() {

        return data.results.size();
    }
}
