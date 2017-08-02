package com.example.deepanshu.learnfragments.network;

import com.example.deepanshu.learnfragments.Course;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by deepanshu on 2/8/17.
 */

public class CourseResponse {

    public Data data;
    public int status;

    public static class Data{

        @SerializedName("courses")
        ArrayList<Course> courseArrayList;

        public ArrayList<Course> getCourseArrayList() {
            return courseArrayList;
        }
    }

}
