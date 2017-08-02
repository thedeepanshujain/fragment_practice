package com.example.deepanshu.learnfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CourseDetailsActivity extends AppCompatActivity {

    String TAG ="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Intent intent = getIntent();
        Course course = (Course) intent.getSerializableExtra(IntentConstants.COURSE);

        CourseDetailsFragment courseDetailsFragment = (CourseDetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.course_details_fragment);
        courseDetailsFragment.setCourse(course);
        //Bundle bundle = new Bundle();
        //bundle.putSerializable(IntentConstants.COURSE,course);
        //courseDetailsFragment.setArguments(bundle);


    }
}
