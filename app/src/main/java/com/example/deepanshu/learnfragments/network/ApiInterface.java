package com.example.deepanshu.learnfragments.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by deepanshu on 2/8/17.
 */

public interface ApiInterface {
    @GET("courses")
    Call<CourseResponse> getCourses();
}
