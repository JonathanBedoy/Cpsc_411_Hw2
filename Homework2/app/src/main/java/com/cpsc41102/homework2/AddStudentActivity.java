package com.cpsc41102.homework2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc41102.homework2.model.Course;
import com.cpsc41102.homework2.model.Student;
import com.cpsc41102.homework2.model.StudentDB;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {
    protected Menu detailMenu;
    protected  final String TAG = "Detail Screen";
    protected Button btn;
    public ArrayList<Course> mCourses = new ArrayList<>();
    public boolean clicked = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        EditText courseView = findViewById(R.id.course_val_id);
        EditText gradeView = findViewById(R.id.grade_val_id);
        courseView.setVisibility(View.GONE);
        gradeView.setVisibility(View.GONE);
        Button btn = (Button) findViewById(R.id.add_vehicle_button_id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText courseView = findViewById(R.id.course_val_id);
                EditText gradeView = findViewById(R.id.grade_val_id);
                if(clicked) {

                    Course c = new Course(courseView.getText().toString(), gradeView.getText().toString());
                    mCourses.add(c);

                    LinearLayout nameView = (LinearLayout) findViewById(R.id.add_course_line);
                    LinearLayout pageView = new LinearLayout(AddStudentActivity.this);
                    LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    pageView.setLayoutParams(params2);
                    pageView.setBackgroundColor(Color.BLACK);
                    pageView.setOrientation(LinearLayout.HORIZONTAL);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1f
                    );
                    params.setMargins(1, 1, 1, 1);

                    TextView tv;
                    tv = new TextView(AddStudentActivity.this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setLayoutParams(params);
                    tv.setText(courseView.getText().toString());
                    pageView.addView(tv);

                    tv = new TextView(AddStudentActivity.this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setLayoutParams(params);
                    tv.setText(gradeView.getText().toString());
                    pageView.addView(tv);

                    nameView.addView(pageView);

                    courseView.setText("");
                    gradeView.setText("");
                } else {
                    courseView.setVisibility(View.VISIBLE);
                    gradeView.setVisibility(View.VISIBLE);
                    clicked=true;
                }



//                nameView.invalidate();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_screen_menu,menu);
        detailMenu = menu;
        menu.findItem(R.id.action_done).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_done){
            EditText fNameView = findViewById(R.id.first_name_val_id);
            EditText lNameView = findViewById(R.id.last_name_val_id);
            EditText cwidView = findViewById(R.id.cwid_val_id);
//            EditText courseView = findViewById(R.id.course_val_id);
//            EditText gradeView = findViewById(R.id.grade_val_id);

//            ArrayList<Course> courses = new ArrayList<>();
//            Course c = new Course(courseView.getText().toString(), gradeView.getText().toString());
//            courses.add(c);


            ArrayList<Student> sList = StudentDB.getInstance().getStudent();
            Student sObj = new Student();
            sObj.setFirstName(fNameView.getText().toString());
            sObj.setLastName(lNameView.getText().toString());
            sObj.setCWID(cwidView.getText().toString());
            sObj.setCourses(mCourses);
            fNameView.setEnabled(false);
            lNameView.setEnabled(false);
            cwidView.setEnabled(false);
            sList.add(sObj);

            StudentDB.getInstance().setStudent(sList);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called ");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}
