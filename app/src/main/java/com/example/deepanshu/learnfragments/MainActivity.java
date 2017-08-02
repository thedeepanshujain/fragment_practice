package com.example.deepanshu.learnfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CourseListFragment courseListFragment = (CourseListFragment) getSupportFragmentManager().findFragmentById(R.id.course_list_fragment);
        courseListFragment.setFragmentItemClickListener(new FragmentItemClickListener() {
            @Override
            public void setFragmentItemClickListener(Course course) {
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.course_container_layout);
                if(frameLayout==null){
                    Intent intent = new Intent(MainActivity.this,CourseDetailsActivity.class);
                    intent.putExtra(IntentConstants.COURSE,course);
                    startActivity(intent);
                }else{
                    CourseDetailsFragment courseDetailsFragment = new CourseDetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(IntentConstants.COURSE,course);
                    courseDetailsFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.course_container_layout,courseDetailsFragment)
                            .commit();
                }

            }
        });
    }
}
