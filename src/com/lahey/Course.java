package com.lahey;
/**
 * @author jack lahey
 */

public class Course {

    //static variables
    private static int iNextCourseNumber = 3001;

    //class variables
    private int IDnumber = 0;
    private String courseName = "";


    /**
     * default constructor sets userid
     *
     * @return void
     */
    public Course() {

        IDnumber = iNextCourseNumber++;
    }


    /**
     * Overloaded constructor takes string courseName
     *
     * @param course name of ccourse to be constructed
     * @return void
     */
    public Course(String course) {

        IDnumber = iNextCourseNumber++;
        this.courseName = course;
    }


    /**
     * Gets course ID number
     *
     * @return ID number
     */
    public int getIDnumber() {
        return this.IDnumber;
    }


    /**
     * set Course Name
     *
     * @param course
     */
    public void setCourseName(String course) {

        this.courseName = course;
    }


    /**
     * get course name
     *
     * @return
     */
    public String getCourseName() {

        return this.courseName;
    }

}//end public class Course

