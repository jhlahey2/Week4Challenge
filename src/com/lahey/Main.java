package com.lahey;
/**
 * @author jack lahey
 */

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
                " \"E\" Engage a teacher for a course," +
                " \"Q\" to Quit";
        String studentMenu = "\nSTUDENT MENU\n" +
                " \"A\" Add a student, \"D\" Display all students," +
                " \"E\" Enroll a student in a course," +
                " \"Q\" to Quit";
        String courseMenu = "\nCOURSE MENU\n" +
                " \"A\" Add a Course, \"D\" Display all Courses, \"Q\" to Quit";

        Scanner scanInput = new Scanner(System.in);
        String sInputString = "";
        String sMenuTeacher = "T";
        String sMenuStudent = "S";
        String sMenuCourse = "C";
        String sMenuQuit = "Q";
        String sMenuAdd = "A";
        String sMenuDisplay = "D";
        String sMenuEnroll = "E";
        String sMenuAssignCourse = "E";

        System.out.println("Welcome to " + school.getSchoolName());

        Main main = new Main();

        //*********************************************************************
        //Main Menu
        //*********************************************************************
        do {

            System.out.println(mainMenu);
            sInputString = scanInput.nextLine();

            if (sInputString.equalsIgnoreCase(sMenuTeacher)) {
                //*********************************************************************
                //teacherMenu: Add Teacher, Display All Teachers, Assign Course, Quit
                //*********************************************************************
                do {

                    System.out.println(teacherMenu);
                    sInputString = scanInput.nextLine();

                    if (sInputString.equalsIgnoreCase(sMenuAdd)) {

                        main.teacherAddNew(scan);
                        sInputString = "";

                    } else if (sInputString.equalsIgnoreCase(sMenuDisplay)) {

                        main.teacherDisplayAll();
                        sInputString = "";

                    } else if (sInputString.equalsIgnoreCase(sMenuAssignCourse)) {

                        main.teacherAssignCourse(scan);
                        sInputString = "";

                    }//end if

                } while (!(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
                        && !(sInputString.equalsIgnoreCase(sMenuAssignCourse))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            } else if (sInputString.equalsIgnoreCase(sMenuStudent)) {

                //*********************************************************************
                //studentMenu: Add Student, Display All Students, Assign Course, Quit
                //*********************************************************************
                do {
                    System.out.println(studentMenu);
                    sInputString = scanInput.nextLine();

                    if (sInputString.equalsIgnoreCase(sMenuAdd)) {

                        main.studentAddNew(scan);
                        sInputString = "";

                    } else if (sInputString.equalsIgnoreCase(sMenuDisplay)) {

                        main.studentDisplayAll();
                        sInputString = "";

                    } else if (sInputString.equalsIgnoreCase(sMenuAssignCourse)) {

                        main.studentAssignCourse(scan);
                        sInputString = "";

                    }//end if

                } while (!(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
                        && !(sInputString.equalsIgnoreCase(sMenuEnroll))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            } else if (sInputString.equalsIgnoreCase(sMenuCourse)) {

                //*********************************************************************
                // courseMenu: Add Course, Display All Courses, Quit
                //*********************************************************************
                do {
                    System.out.println(courseMenu);
                    sInputString = scanInput.nextLine();

                    if (sInputString.equalsIgnoreCase(sMenuAdd)) {

                        main.courseAddNew(scan);
                        sInputString = "";

                    } else if (sInputString.equalsIgnoreCase(sMenuDisplay)) {

                        main.courseDisplayAll();
                        sInputString = "";

                    }//end if

                } while (!(sInputString.equalsIgnoreCase(sMenuAdd))
                        && !(sInputString.equalsIgnoreCase(sMenuDisplay))
                        && !(sInputString.equalsIgnoreCase(sMenuQuit)));

                sInputString = "";

            }//end if

        } while (!(sInputString.equalsIgnoreCase(sMenuTeacher))
                && !(sInputString.equalsIgnoreCase(sMenuStudent))
                && !(sInputString.equalsIgnoreCase(sMenuCourse))
                && !(sInputString.equalsIgnoreCase(sMenuQuit)));

        System.out.println("\nThank you for visiting " + school.getSchoolName());

    }//end public static void main(String[] args)

    //*************************************************************************
    //* Teacher Menu Methods
    //*************************************************************************

    /**
     * add new teacher
     *
     * @param scan input scanner
     */
    public void teacherAddNew(Scanner scan) {
        System.out.println("Add Teacher");

        System.out.println("Enter First Name:");
        String firstName = scan.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scan.nextLine();

        System.out.println("Enter Email:");
        String emailAddress = scan.nextLine();

        school.addTeacher(firstName, lastName, emailAddress);

    }//end public void teacherAddNew(Scanner scan)


    /**
     * display all teachers
     *
     */
    public void teacherDisplayAll() {
        System.out.println("Display All Teachers");
        ArrayList<Teacher> list = school.getTeachers();

        for (Teacher temp : list) {
            displayTeacher(temp);
        }
    }


    /**
     * display a teacher
     *
     * @param teacher
     */
    public void displayTeacher(Teacher teacher) {

        System.out.println("\n");
        System.out.println(teacher.getClass().getSimpleName() +" ID Number:  " + teacher.getIDnumber());
        System.out.println("First Name: " + teacher.getFirstName());
        System.out.println("Last Name:  " + teacher.getLastName());
        System.out.println("Email:      " + teacher.getEmailAddress());

        System.out.println("Teaches:    " + school.getTeacherCourses(teacher));

    }//end public void displayTeacher(Teacher teacher)


    /**
     * assigns teacher to course
     *
     * @param scan
     */
    public void teacherAssignCourse(Scanner scan) {

        String sMenuYes = "Y";
        String sMenuNo = "N";
        int courseID = 0;
        int teacherID = 0;
        String sContinue = "";
        Course course = null;
        boolean bContinue = false;


        do {

            System.out.println("\n\t**Please note that you will need both the Teacher ID Number and the Course ID Number **\n");

            System.out.println("Do you want to continue, Y or N?");

            sContinue = scan.nextLine();

        } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

        if (sContinue.equalsIgnoreCase(sMenuYes)) {

            bContinue = true;
        }


        if (bContinue) {

            do {
                System.out.println("Assign Teacher To Course");

                System.out.println("Enter the Teacher ID Number: ");
                while (!scan.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scan.nextLine(); //catch the enter key
                }
                teacherID = scan.nextInt();
                scan.nextLine();

                Teacher teacher = school.getTeacherByID(teacherID);

                if (!(teacher == null)) {

                    displayTeacher(teacher);

                    do {
                        System.out.println("\nEnter the Course ID Number: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("\nThat's not a number!");
                            scan.nextLine(); //catch the enter key
                        }
                        courseID = scan.nextInt();
                        scan.nextLine();

                        course = school.getCourseByID(courseID);

                        if (!(course == null)) {

                            displayCourse(course);
                            System.out.println("\n");

                            if (school.assignTeacherCourse(teacher, course)) {

                                System.out.printf("Teacher %s %s has been assigned to teach %s. ", teacher.getFirstName(),
                                        teacher.getLastName(), course.getCourseName());

                            } else {

                                System.out.printf("Teacher %s %s is ALREADY assigned to teach %s. ", teacher.getFirstName(),
                                        teacher.getLastName(), course.getCourseName());
                            }
                        } else {

                            System.out.printf("Sorry, course %d was not found at %s", courseID, school.getSchoolName());
                        }

                        do {

                            System.out.println("Do you want to assign another Course, Y or N?");

                            sContinue = scan.nextLine();

                        } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

                    } while ((sContinue.equalsIgnoreCase(sMenuYes)));
                } else {

                    System.out.printf("Sorry, teacher %d was not found at %s.  ", teacherID, school.getSchoolName());
                }


                do {

                    System.out.println("Do you want to assign Courses to another teacher, Y or N?");

                    sContinue = scan.nextLine();

                } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

            } while ((sContinue.equalsIgnoreCase(sMenuYes)));

        }//end if(bContinue)

    }//end public void teacherAssignCourse(Scanner scan)


    //*************************************************************************
    //* Student Menu Methods
    //*************************************************************************

    /**
     * add new student
     *
     * @param scan input scanner
     */
    public void studentAddNew(Scanner scan) {

        System.out.println("Add Student");

        System.out.println("Enter First Name:");
        String firstName = scan.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scan.nextLine();

        System.out.println("Enter Email:");
        String emailAddress = scan.nextLine();

        school.addStudent(firstName, lastName, emailAddress);

    }//end public void studentAddNew(Scanner scan)


    /**
     * display all students
     *
     */
    public void studentDisplayAll() {

        System.out.println("Display All Students");
        ArrayList<Student> list = school.getStudents();

        for (Student temp : list) {

            displayStudent(temp);
        }

    }//end public void studentDisplayAll()


    /**
     * display a student
     *
     * @param student
     */
    public void displayStudent(Student student) {

        System.out.println("\n");
        System.out.println(student.getClass().getSimpleName() + " ID Number:  " + student.getIDnumber());
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name:  " + student.getLastName());
        System.out.println("Email:      " + student.getEmailAddress());

        System.out.println("Takes:      " + school.getStudentCourses(student));

    }//end public void displayStudent(Student student)


    /**
     * assign a student to a course
     *
     * @param scan input scanner
     */
    public void studentAssignCourse(Scanner scan) {

        String sMenuYes = "Y";
        String sMenuNo = "N";
        int courseID = 0;
        int studentID = 0;
        String sContinue = "";
        Course course = null;
        boolean bContinue = false;


        do {

            System.out.println("\n\t**Please note that you will need both the Student ID Number and the Course ID Number **\n");

            System.out.println("Do you want to continue, Y or N?");

            sContinue = scan.nextLine();

        } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

        if (sContinue.equalsIgnoreCase(sMenuYes)) {

            bContinue = true;
        }

        if (bContinue) {

            do {
                System.out.println("Assign Student To Course");

                System.out.println("Enter the Student ID Number: ");
                while (!scan.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scan.nextLine(); //catch the enter key
                }
                studentID = scan.nextInt();
                scan.nextLine();

                Student student = school.getStudentByID(studentID);

                if (!(student == null)) {

                    displayStudent(student);

                    do {
                        System.out.println("\nEnter the Course ID Number: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("\nThat's not a number!");
                            scan.nextLine(); //catch the enter key
                        }
                        courseID = scan.nextInt();
                        scan.nextLine();

                        course = school.getCourseByID(courseID);

                        if (!(course == null)) {

                            displayCourse(course);
                            System.out.println("\n");

                            if (school.assignStudentCourse(student, course)) {

                                System.out.printf("Student %s %s has been enrolled in %s. ", student.getFirstName(),
                                        student.getLastName(), course.getCourseName());

                            } else {

                                System.out.printf("Student %s %s was ALREADY enrolled in %s. ", student.getFirstName(),
                                        student.getLastName(), course.getCourseName());
                            }
                        } else {

                            System.out.printf("Sorry, course %d was not found at %s", courseID, school.getSchoolName());
                        }

                        do {

                            System.out.println("Do you want to add another Course, Y or N?");

                            sContinue = scan.nextLine();

                        } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

                    } while ((sContinue.equalsIgnoreCase(sMenuYes)));
                } else {

                    System.out.printf("Sorry, student %d was not found at %s.  ", studentID, school.getSchoolName());
                }


                do {

                    System.out.println("Do you want to enroll another student in Courses , Y or N?");

                    sContinue = scan.nextLine();

                } while (!(sContinue.equalsIgnoreCase(sMenuYes)) && !(sContinue.equalsIgnoreCase(sMenuNo)));

            } while ((sContinue.equalsIgnoreCase(sMenuYes)));

        }//end if(bContinue)

    }//end public void studentAssignCourse(Scanner scan)


    //*************************************************************************
    //* Course Menu Methods
    //*************************************************************************

    /**
     * add a new course
     *
     * @param scan input scanner
     */
    public void courseAddNew(Scanner scan) {
        System.out.println("Add Course");

        System.out.println("Enter Course Name:");
        String courseName = scan.nextLine();

        school.addCourse(courseName);

    }//end public void courseAddNew(Scanner scan)


    /**
     * display all courses
     *
     */
    public void courseDisplayAll() {
        System.out.println("Display All Courses");
        ArrayList<Course> list = school.getCourses();

        for (Course temp : list) {
            displayCourse(temp);
            System.out.println("\n");
        }

    }//end public void courseDisplayAll()


    /**
     * display a course
     *
     * @param course
     */
    public void displayCourse(Course course) {

        System.out.println(course.getClass().getSimpleName() +" ID Number:  " + course.getIDnumber());
        System.out.println("Course Name:        " + course.getCourseName());

    }//end public void displayCourse(Course course)


}//end public class Main
