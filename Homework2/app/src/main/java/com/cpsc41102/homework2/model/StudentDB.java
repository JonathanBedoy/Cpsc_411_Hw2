package com.cpsc41102.homework2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> mStudent;

    static public StudentDB getInstance(){
        return ourInstance;
    }

    private StudentDB(){
//        createStudentObjects();
    }


    public ArrayList<Student> getStudent(){
        return mStudent;
    }

    public void setStudent(ArrayList<Student> student){
        mStudent = student;
    }
}
