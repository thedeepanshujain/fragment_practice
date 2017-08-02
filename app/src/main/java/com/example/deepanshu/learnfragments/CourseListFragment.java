package com.example.deepanshu.learnfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.deepanshu.learnfragments.network.ApiInterface;
import com.example.deepanshu.learnfragments.network.CourseResponse;
import com.example.deepanshu.learnfragments.network.RetrofitClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CourseListFragment extends Fragment {

    ArrayList<Course> courseArrayList;
    ListView listView;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> courseTitleArrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_list,container,false);
        listView = (ListView) v.findViewById(R.id.list_view);

        courseArrayList = new ArrayList<>();
        courseTitleArrayList = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,courseTitleArrayList);
        listView.setAdapter(mAdapter);
        fetchCourses();
        return v;
    }

    private void fetchCourses() {

        Retrofit retrofit = RetrofitClass.getRetrofitInstance();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<CourseResponse> courseResponseCall = apiInterface.getCourses();

        courseResponseCall.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                CourseResponse courseResponse = response.body();
                ArrayList<Course> fetchedArrayList = courseResponse.data.getCourseArrayList();

                courseArrayList.clear();
                courseTitleArrayList.clear();
                courseArrayList.addAll(fetchedArrayList);

                for(Course course : courseArrayList){
                    courseTitleArrayList.add(course.getTitle());
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });

    }
}
