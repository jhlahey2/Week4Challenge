package com.lahey;

public class Course {

    private static int iNextCourseNumber = 3001;

    private int IDnumber = 0;
    private String courseName = "";

    //*************************************************************************
    //* default constructor sets user id
    //*************************************************************************
    public Course (){

        IDnumber = iNextCourseNumber++;
    }

    public Course(String course){

        IDnumber = iNextCourseNumber++;
        this.courseName = course;
    }

    public int getIDnumber() {
        return this.IDnumber;
    }

    public void setCourseName(String course){

        this.courseName = course;
    }
    public String getCourseName(){

        return this.courseName;
    }

}//end public class Course

