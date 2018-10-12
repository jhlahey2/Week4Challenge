package com.lahey;

public class Person {

    private static int iNextStudentIDNumber = 101;

    //*************************************************************************
    //* default constructor sets user id
    //*************************************************************************
    public Person (){

        IDnumber = iNextStudentIDNumber++;
    }

//    //*************************************************************************
//    //* overloaded constructor sets user id
//    //*************************************************************************
//    public Person (String firstName, String lastName, String emailAddress){
//
//        IDnumber = iNextStudentIDNumber++;
//        super.setFirstName(firstName);
//        super.lastName = lastName;
//        this.emailAddress = emailAddress
//    }

    public int getIDnumber() {
        return IDnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private int IDnumber = 0;
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";


}
