package com.cpsc41102.homework2.model;

public class Course {
    protected String mCourseId;
    protected String mGrade;

    public Course(String courseId, String grade) {
        mCourseId = courseId;
        mGrade = grade;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String courseId) {
        mCourseId = courseId;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }
}
