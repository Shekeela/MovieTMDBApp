package com.example.movietmdb;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("original_language")
    public String language;

    @SerializedName("original_title")
    public String movieName;

    @SerializedName("poster_path")
    public String posterpath;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public float popularity;

    @SerializedName("release_date")
    public String release_date;

    @SerializedName("vote_count")
    public int vote_count;

    @SerializedName("vote_average")
    public float vote_average;

    @SerializedName("id")
    public int id;


    public String getPosterPath() {
        return posterpath;
    }

    public String getImageURL() {

        return "https://image.tmdb.org/t/p/w780/" + getPosterPath();

    }
    public int getMovieId(){
        return id;
    }
    public String getLanguage() {
        return language;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getOverview() {
        return overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public float getVote_count() {
        return vote_count;
    }

    public float getVote_average() {
        return vote_average;
    }

}
