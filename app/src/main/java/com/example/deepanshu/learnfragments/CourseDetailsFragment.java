package com.example.deepanshu.learnfragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CourseDetailsFragment extends Fragment {


    Course course;
    TextView nameTextView;
    TextView isActiveTextView;
    TextView overviewTextView;
    TextView feeTextView;
    Button enrolButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("TAG", "onCreateView: ");
        View v = inflater.inflate(R.layout.fragment_course_details,container,false);
        nameTextView = (TextView) v.findViewById(R.id.name_text_view);
        isActiveTextView = (TextView) v.findViewById(R.id.active_text_view);
        overviewTextView = (TextView) v.findViewById(R.id.overview_text_view);
        feeTextView = (TextView) v.findViewById(R.id.fee_text_view);
        enrolButton = (Button) v.findViewById(R.id.enrol_button);

        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            course = (Course) bundle.getSerializable(IntentConstants.COURSE);
            setCourse(course);
        }
        return v;
    }

    public void setCourse(Course course) {
        this.course = course;
        boolean ifActive = course.isIsActive();
        String isActiveText = ifActive ? "ACTIVE" : "INACTIVE";

        nameTextView.setText(course.getName());
        isActiveTextView.setText(isActiveText);
        overviewTextView.setText(course.getOverview());
        feeTextView.setText(course.getFeeWithTaxes() + "/-");

        enrolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://codingninjas.in/app/payment?ctype=offline");
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(implicitIntent);
            }
        });
    }
}
