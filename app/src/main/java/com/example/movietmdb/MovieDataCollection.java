package com.example.movietmdb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDataCollection {

    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public ArrayList<Results> results = new ArrayList<Results>();



}
