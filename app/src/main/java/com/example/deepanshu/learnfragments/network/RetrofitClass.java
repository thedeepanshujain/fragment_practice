package com.example.deepanshu.learnfragments.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepanshu on 2/8/17.
 */

public class RetrofitClass {

    public static Retrofit retrofitInstance;

    public static Retrofit getRetrofitInstance(){
        if(retrofitInstance==null){
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("https://codingninjas.in/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofitInstance;
    }
}
