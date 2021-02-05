package com.example.movietmdb;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView recyclerViewitemMOvieImage;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        recyclerViewitemMOvieImage = (ImageView)itemView.findViewById(R.id.recyclerViewitemMOvieImage);
    }
}

