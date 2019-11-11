package com.cpsc41102.homework2.model;

import com.cpsc41102.homework2.model.Course;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected String mCWID;
    protected ArrayList<Course> mCourses;
    public Student(){}

    public Student(String fName, String lName, String CWID) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = CWID;
    }

    public String getCWID() {
        return mCWID;
    }

    public void setCWID(String CWID) {
        mCWID = CWID;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    public ArrayList<Course> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<Course> courses) {
        mCourses = courses;
    }

}
