package com.lahey;
/**
 * @author jack lahey
 */

import java.util.*;

public class School {

    //School Name
    private String schoolName = "Wet Pants Sailing School";
    //class variables
    private int IDnumber = 0;
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";

    //list of Course objects
    private ArrayList<Course> courseList = new ArrayList<Course>();
    //list of Student objects
    private ArrayList<Student> studentList = new ArrayList<Student>();
    //list of Teacher objects
    private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    //map of 1:m Teacher:Course objects
    private HashMap<Teacher, HashSet<Course>> teacherCourseMap = new HashMap<Teacher, HashSet<Course>>();
    //map of 1:m Student:Course objects
    private HashMap<Student, HashSet<Course>> studentCourseMap = new HashMap<Student, HashSet<Course>>();

    /**
     * Default constructor initializes class collections with Students, Teachers, Courses
     */
    public School(){

        initializeSchool();

    }//end public School()


    /**
     * get school name
     *
     * @return name of school
     */
    public String getSchoolName() {

        return schoolName;

    }//end public String getSchoolName()


    /**
     * add Student to student list
     *
     * @param firstName
     * @param lastName
     * @param emailAddress
     */
    public void addStudent(String firstName, String lastName, String emailAddress){

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmailAddress(emailAddress);
        //add Student to Student list
        studentList.add(student);
        //add Student to 1:m Student:Course map
        studentCourseMap.put(student, new HashSet());

    }//end public void addStudent(String firstName, String lastName, String emailAddress)


    /**
     * add Teacher to teacher list
     *
     * @param firstName
     * @param lastName
     * @param emailAddress
     */
    public void addTeacher(String firstName, String lastName, String emailAddress){

        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmailAddress(emailAddress);
        //add Teacher to teacher list
        teacherList.add(teacher);
        //add Teacher to 1:m Teacher:Course map
        teacherCourseMap.put(teacher, new HashSet());

    }//end public void addTeacher(String firstName, String lastName, String emailAddress)

    /**
     * add Course to course list
     *
     * @param name name of course to construct and add to list
     */
    public void addCourse(String name){

        Course course = new Course();
        course.setCourseName(name);
        courseList.add(course);

    }//end public void addCourse(String name)


    /**
     * get Student list
     *
     * @return list of all students
     */
    public ArrayList<Student> getStudents(){

        return studentList;

    }//end public ArrayList<Student> getStudents()

    /**
     * get Teacher list
     *
     * @return list of all teachers
     */
    public ArrayList<Teacher> getTeachers(){

        return teacherList;

    }//end public ArrayList<Teacher> getTeachers()

    /**
     * get Course list
     *
     * @return list of all courses
     */
    public ArrayList<Course> getCourses(){

        return courseList;

    }//end public ArrayList<Course> getCourses()


    /**
     * get Course by id from course list : returns course or null
     *
     * @param courseID
     * @return course
     */
    public Course getCourseByID(int courseID){

        for(Course course : courseList){

            if(course.getIDnumber() == courseID){

                return course;

            }

        }//end for(Course course : courseList

        return null;

    }//end public Course getCourseByID(int courseID)


    /**
     * get Teacher by id from teacher list: returns teacher or null
     *
     * @param teacherID
     * @return teacher
     */
    public Teacher getTeacherByID(int teacherID){

        for(Teacher teacher : teacherList){

            if(teacher.getIDnumber() == teacherID)

                return teacher;
        }

        return null;

    }//end public Teacher getTeacherByID(int teacherID)

    /**
     * get Student by id from student list : returns student or null
     *
     * @param studentID
     * @return student
     */
    public Student getStudentByID(int studentID){

        for(Student student : studentList){

            if(student.getIDnumber() == studentID)

                return student;
        }

        return null;

    }//end public Student getStudentByID(int studentID)


    /**
     * maps a Course to a Teacher in 1:m Teacher:Course map
     *
     * @param teacher
     * @param course
     * @return true if teacher is asssigned to course, false if exists
     */
    public boolean assignTeacherCourse(Teacher teacher, Course course){

        //get Courses associated with Teacher
        HashSet<Course> hsTemp = teacherCourseMap.get(teacher);

        //return true if value added and false if already in HashSet
        return hsTemp.add(course);

    }//end public boolean assignTeacherCourse(Teacher teacher, Course course)


    /**
     * gets all Courses mapped to a Teacher in 1:m Teacher:Course map
     *
     * @param teacher
     * @return string list of courses a teacher has been assigned to teach
     */
    public String getTeacherCourses(Teacher teacher){

        StringBuffer buffer = new StringBuffer();

        //get Courses associated with Teacher
        HashSet<Course> hsTemp = teacherCourseMap.get(teacher);

        if( !(hsTemp.isEmpty()) ){

            String prefix = "";
            for(Course course : hsTemp){

                buffer.append(prefix);
                prefix = ", ";
                buffer.append(course.getCourseName());

            }//end for(Course course : hsTemp)

        }
        else{

            buffer.append("not assigned to any courses");

        }//end if( !(hsTemp.isEmpty()) )

        return buffer.toString();

    }//end public String getTeacherCourses(Teacher teacher)

    /**
     * maps a Course to a Student in 1:m Student:Course map
     *
     * @param student
     * @param course
     * @return true if course is added to Set, false if already exists
     */
    public boolean assignStudentCourse(Student student, Course course){

        //get Courses associated with Teacher
        HashSet<Course> hsTemp = studentCourseMap.get(student);

        //return true if value added and false if already in HashSet
        return hsTemp.add(course);

    }//end public boolean assignStudentCourse(Student student, Course course)


    /**
     * gets all Courses mapped to a Student in 1:m Student:Course map
     *
     * @param student
     * @return string list of courses for which student is enrolled
     */
    public String getStudentCourses(Student student){

        StringBuffer buffer = new StringBuffer();

        //get Courses associated with Teacher
        HashSet<Course> hsTemp = studentCourseMap.get(student);

        if( !(hsTemp.isEmpty()) ){

            String prefix = "";
            for(Course course : hsTemp){

                buffer.append(prefix);
                prefix = ", ";
                buffer.append(course.getCourseName());

            }//end for(Course course : hsTemp)

        }
        else{

            buffer.append("not enrolled in any courses");

        }//end if( !(hsTemp.isEmpty()) )

        return buffer.toString();

    }//end public String getTeacherCourses(Teacher teacher)


    /**
     * initialize school collections with data
     */
    private void initializeSchool(){

        //addTeacher(String firstName, String lastName, String emailAddress)
        this.addTeacher("Dave", "Wolf", "dave@wolf.com");
        this.addTeacher("Afia", "Ankama", "fi@ankama.com");
        this.addTeacher("Alton", "Henley", "alton@henley.com");

        //addStudent(String firstName, String lastName, String emailAddress)
        this.addStudent("Bob", "Woodward", "bob@allthepresidentsmen.com");
        this.addStudent("Harper", "Lee", "bob@email.com");
        this.addStudent("Rudyard","Kipling", "rudyard@junglebook.com");

        //addCourse(String name)
        this.addCourse("Java");
        this.addCourse("Python");
        this.addCourse("COBOL");

    }//end private void initializeSchool()

}//end public class School
