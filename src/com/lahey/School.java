package com.lahey;

import java.util.*;

public class School {

    private String schoolName = "Wet Pants Sailing School";

    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();


    // Maps for teacher-courses & student-courses
    //private Map<String, List<String>> teacherCourseMap = new HashMap<String, List<String>>();

    //private HashMap<int, ArrayList<Course>> teacherCourseMap = new HashMap<Teacher, ArrayList<Course>>();

    //private HashMap<Student, ArrayList<Course>> studentCourseMap = new HashMap<Student, ArrayList<Course>>();

    //*************************************************************************
    //*
    //*************************************************************************

    public String getSchoolName() {

        return schoolName;
    }

    private int IDnumber = 0;
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";

    public void addStudent(String firstName, String lastName, String emailAddress){

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmailAddress(emailAddress);
        studentList.add(student);
    }

    public void addTeacher(String firstName, String lastName, String emailAddress){

        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmailAddress(emailAddress);
        teacherList.add(teacher);
    }

    public void addCourse(String name){

        Course course = new Course();
        course.setCourseName(name);
        courseList.add(course);
    }

    public ArrayList<Student> getStudents(){

        return studentList;
    }

    public ArrayList<Teacher> getTeachers(){

        return teacherList;
    }

    public ArrayList<Course> getCourses(){

        return courseList;
    }

    public void assignTeacherCourse(int teacherID, int courseID){

        //to be completed

        //check to see if the teacher is already in the Hashmap
        //if the teacher is already in the hashmap get the list
        //  add course to the list
        //  update hashmap
        //else
        //  create new list
        //  add to hashmap
    }

    public ArrayList getTeacherCourses(){

        //to be completed

        return new ArrayList();
    }

    public void assignStudentCourse(int studentID, int courseID){

        //to be completed
        //----------------------------
        //TO DO
        //check to see if the teacher is already in the Hashmap
        //if the teacher is already in the hashmap get the list
        //  add course to the list
        //  update hashmap
        //else
        //  create new list
        //  add to hashmap
        //-----------------------------

    }

    public ArrayList getStudentCourses(){

        //to be completed
        return new ArrayList();
    }

    public Teacher getTeacherByID(int teacherID){

        //to be completed
        return new Teacher();
    }

}//end public class School
