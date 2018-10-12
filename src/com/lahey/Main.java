package com.lahey;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final School school = new School();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //mainMenu: Teacher, Student, Course
        String mainMenu = "\nMAIN MENU\n" +
                " \"T\" work with Teachers, \"S\" work with Students, \"C\" work with Courses, \"Q\" to Quit";
        String teacherMenu = "\nTEACHER MENU\n" +
                " \"A\" Add a Teacher, \"D\" Display all Teachers," +
//                " \"C\" assign a Course to a teacher," +
                " \"Q\" to Quit";
        String studentMenu = "\nSTUDENT MENU\n" +
                " \"A\" Add a Student, \"D\" Display all Students," +
//                " \"E\" enroll a student in a Course," +
                " \"Q\" to Quit";
        String courseMenu = "\nCOURSE MENU\n" +
                " \"A\" Add a Course, \"D\" Display all Courses, \"Q\" to Quit";

        Scanner scanInput = new Scanner(System.in);
        String sInputString = "";
        String sMenuTeacher = "T";
        String sMenuStudent = "S";
        String sMenuCourse  = "C";
        String sMenuQuit    = "Q";
        String sMenuAdd     = "A";
        String sMenuDisplay = "D";
//        String sMenuEnroll  = "E";
//        String sMenuAssignCourse   = "N";

        System.out.println("Welcome to " + school.getSchoolName());

        Main main = new Main();

        //*********************************************************************
        //Main Menu
        //*********************************************************************
        do {

            System.out.println(mainMenu);
            sInputString = scanInput.nextLine();

            if(sInputString.equalsIgnoreCase(sMenuTeacher))
            {
                //*********************************************************************
                //teacherMenu: Add Teacher, Display All Teachers, Assign Course, Quit
                //*********************************************************************
                do {

                    System.out.println(teacherMenu);
                    sInputString = scanInput.nextLine();

                    if(sInputString.equalsIgnoreCase(sMenuAdd)){

                        main.teacherAddNew(scan);
                        sInputString = "";

                    }else if(sInputString.equalsIgnoreCase(sMenuDisplay)){

                        main.teacherDisplayAll();
                        sInputString = "";

//                    }else if(sInputString.equalsIgnoreCase(sMenuAssignCourse)) {
//
//                        main.teacherAssignCourse(scan);
//                        sInputString = "";

                    }//end if

                }while( !(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
//                        && !(sInputString.equalsIgnoreCase(sMenuAssignCourse))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            }else if(sInputString.equalsIgnoreCase(sMenuStudent)){

                //*********************************************************************
                //studentMenu: Add Student, Display All Students, Assign Course, Quit
                //*********************************************************************
                do {
                    System.out.println(studentMenu);
                    sInputString = scanInput.nextLine();

                    if(sInputString.equalsIgnoreCase(sMenuAdd)){

                        main.studentAddNew(scan);
                        sInputString = "";

                    }else if(sInputString.equalsIgnoreCase(sMenuDisplay)){

                        main.studentDisplayAll();
                        sInputString = "";

//                    }else if(sInputString.equalsIgnoreCase(sMenuAssignCourse)) {
//
//                        main.studentAssignCourse(scan);
//                        sInputString = "";
//
                    }//end if

                }while( !(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
//                        && !(sInputString.equalsIgnoreCase(sMenuAssignCourse))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            }else if(sInputString.equalsIgnoreCase(sMenuCourse)) {

                //*********************************************************************
                // courseMenu: Add Course, Display All Courses, Quit
                //*********************************************************************
                do {
                    System.out.println(courseMenu);
                    sInputString = scanInput.nextLine();

                    if(sInputString.equalsIgnoreCase(sMenuAdd)){

                        main.courseAddNew(scan);
                        sInputString = "";

                    }else if(sInputString.equalsIgnoreCase(sMenuDisplay)){

                        main.courseDisplayAll();
                        sInputString = "";

                    }//end if

                }while( !(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            }//end if

        }while( !(sInputString.equalsIgnoreCase(sMenuTeacher))
                && !(sInputString.equalsIgnoreCase(sMenuStudent))
                && !(sInputString.equalsIgnoreCase(sMenuCourse))
                && !(sInputString.equalsIgnoreCase(sMenuQuit)));

        System.out.println("\nThank you for visiting " + school.getSchoolName());

    }//end public static void main(String[] args)

    //*************************************************************************
    //* Teacher Menu Methods
    //*************************************************************************
    public void teacherAddNew(Scanner scan)
    {
        System.out.println("Add Teacher");

        System.out.println("Enter First Name:");
        String firstName = scan.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scan.nextLine();

        System.out.println("Enter Email:");
        String emailAddress = scan.nextLine();

        school.addTeacher(firstName, lastName, emailAddress);
    }

    public void teacherDisplayAll()
    {
        System.out.println("Display All Teachers");
        ArrayList<Teacher> list = school.getTeachers();

        for (Teacher temp : list)
        {
            System.out.println("\n");
            System.out.println("ID Number:  " + temp.getIDnumber());
            System.out.println("First Name: " + temp.getFirstName());
            System.out.println("Last Name:  " + temp.getLastName());
            System.out.println("Email:      " + temp.getEmailAddress());

            System.out.println("Teaches:    " + "(To be completed)");
        }
    }

    public void teacherAssignCourse(Scanner scan)
    {
        System.out.println("Assign Teacher To Course");
        System.out.println("\n\t**Please note that you will need both the Teacher ID Number and the Course ID Number **\n");
        System.out.println("Enter the Teacher ID Number: ");
        int teacherID = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the Course ID Number: ");
        int courseID = scan.nextInt();
        scan.nextLine();

        school.assignTeacherCourse(teacherID, courseID);

    }

    //*************************************************************************
    //* Student Menu Methods
    //*************************************************************************
    public void studentAddNew(Scanner scan)
    {
        System.out.println("Add Student");

        System.out.println("Enter First Name:");
        String firstName = scan.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scan.nextLine();

        System.out.println("Enter Email:");
        String emailAddress = scan.nextLine();

        school.addStudent(firstName, lastName, emailAddress);
    }

    public void studentDisplayAll()
    {
        System.out.println("Display All Students");
        ArrayList<Student> list = school.getStudents();

        for (Student temp : list)
        {
            System.out.println("\n");
            System.out.println("ID Number:  " + temp.getIDnumber());
            System.out.println("First Name: " + temp.getFirstName());
            System.out.println("Last Name:  " + temp.getLastName());
            System.out.println("Email:      " + temp.getEmailAddress());

            System.out.println("Takes:      " + "(To be completed)");

        }
    }

    public void studentAssignCourse(Scanner scan)
    {

        System.out.println("to be completed");

        System.out.println("Enroll Student in Course");
        System.out.println("\n\t**Please note that you will need both the Student ID Number and the Course ID Number **\n");
        System.out.println("Enter the Student ID Number: ");
        int studentID = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the Course ID Number: ");
        int courseID = scan.nextInt();
        scan.nextLine();

        school.assignTeacherCourse(studentID, courseID);

    }

    //*************************************************************************
    //* Course Menu Methods
    //*************************************************************************
    public void courseAddNew(Scanner scan)
    {
        System.out.println("Add Course");

        System.out.println("Enter Course Name:");
        String courseName = scan.nextLine();

        school.addCourse(courseName);
    }

    public void courseDisplayAll()
    {
        System.out.println("Display All Courses");
        ArrayList<Course> list = school.getCourses();

        for (Course temp : list)
        {
            System.out.println("\n");
            System.out.println("ID Number:  " + temp.getIDnumber());
            System.out.println("Course Name: " + temp.getCourseName());
        }
    }


}//end public class Main
