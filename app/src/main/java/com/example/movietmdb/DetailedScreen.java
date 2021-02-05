package com.example.movietmdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailedScreen extends AppCompatActivity {

    ImageView detailedImageviewid;
    TextView languageid,movieNameid,overviewid,popularityid,release_dateid,vote_countid,vote_averageid;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedscreen);

        detailedImageviewid = findViewById(R.id.detailedImageviewid);
        languageid = findViewById(R.id.languageid);
        movieNameid = findViewById(R.id.movieNameid);
        overviewid = findViewById(R.id.overviewid);
        popularityid = findViewById(R.id.popularityid);
        release_dateid = findViewById(R.id.release_dateid);
        vote_countid = findViewById(R.id.vote_countid);
        vote_averageid = findViewById(R.id.vote_averageid);

        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();

        String language =bundle.getString("languageid");
        String imageurl =bundle.getString("image");
        String movieName = bundle.getString("moviename");
        String overview = bundle.getString("overview");
        String popularity= bundle.getString("popularity");
        String release_date = bundle.getString("releasedate");
        String vote_count = bundle.getString("votecount");
        String vote_average = bundle.getString("voteavaregare");



        Picasso.with(context).load(imageurl).into(detailedImageviewid);
        languageid.setText("Language : "+language);
        movieNameid.setText("Movie Name : "+movieName);
        overviewid.setText("Overview : "+overview);
        popularityid.setText("Popularity : "+popularity);
        release_dateid.setText("Release Date : "+release_date);
        vote_countid.setText("Vote Count : "+vote_count);
        vote_averageid.setText("Vote Average : "+vote_average);

    }
}






