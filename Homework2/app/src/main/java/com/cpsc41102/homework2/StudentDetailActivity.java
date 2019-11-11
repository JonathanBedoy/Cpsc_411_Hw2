package com.cpsc41102.homework2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc41102.homework2.model.Course;
import com.cpsc41102.homework2.model.Student;
import com.cpsc41102.homework2.model.StudentDB;

import java.util.ArrayList;

public class StudentDetailActivity extends AppCompatActivity {
    protected Student sObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

//
        int personIndex = getIntent().getIntExtra("PersonIndex", 0);
        TextView tv = findViewById(R.id.display_string_cwid);
        //Display the Person Index

        Student student = StudentDB.getInstance().getStudent().get(personIndex);
        tv.setText(" "+ student.getCWID());
//
        tv = findViewById(R.id.display_string_name);
        tv.setText(student.getFirstName()+ " "+ student.getLastName());
//
        ArrayList<Course> courses = student.getCourses();


        LinearLayout nameView = (LinearLayout) findViewById(R.id.display_courses_name);
////        LayoutInflater nameInflater = LayoutInflater.from(this);
        LinearLayout gradeView = (LinearLayout) findViewById(R.id.display_courses_grade);
////        LayoutInflater gradeInflater = LayoutInflater.from(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(3,3,3,3);
        int len = 0;
        if(courses != null) {
            len = courses.size();
        }

        for(int i = 0; i < len; i++) {

            tv = new TextView(this);
            tv.setText(courses.get(i).getCourseId());
            tv.setTextColor(Color.GRAY);
            tv.setTextSize(24);
            tv.setBackgroundColor(Color.WHITE);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(params);
            nameView.addView(tv);
            tv = new TextView(this);
            tv.setText(courses.get(i).getGrade());
            tv.setTextColor(Color.GRAY);
            tv.setTextSize(24);
            tv.setBackgroundColor(Color.WHITE);
            tv.setGravity(Gravity.CENTER);
            tv.setLayoutParams(params);
            gradeView.addView(tv);

        }
    }
}