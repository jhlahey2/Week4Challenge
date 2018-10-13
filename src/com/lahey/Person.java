package com.lahey;
/**
 * @author jack lahey
 */

public class Person {

    //static variables
    private static int iNextStudentIDNumber = 101;

    //class variables
    private int IDnumber = 0;
    private String firstName = "";
    private String lastName = "";
    private String emailAddress = "";


    /**
     * default constructor sets user IDnumber
     * there is no setter, as IDnumber is a unique identifier
     * that is set by the constructor
     *
     */
    public Person (){

        IDnumber = iNextStudentIDNumber++;
    }


    /**
     * get id number
     *
     * @return unique person id number
     */
    public int getIDnumber() {
        return IDnumber;
    }


    /**
     * get first name
     *
     * @return First Name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * set first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * get last name
     *
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * set last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * get email address
     *
     * @return emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }


    /**
     * set email address
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}//end public class Person
