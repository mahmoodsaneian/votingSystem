package com.company;

/**
 * this class maintains characteristics of person who wants be present in voting.
 * & contain first name and last name of person.
 *
 * @author   mahmood-saneian.
 * @since    2021-4-12.
 * @version  15.0.2
 */
public class Person {
    //the first name of person
    private String firstName;
    //the last name of person
    private String lastName;

    /**
     * this constructor initialize characteristics of a person.
     * @param firstName first name of person.
     * @param lastName  last  name of  person.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * this method return first name of person to us.
     * @return first name of person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * this method return last name of a person to us.
     * @return last name of a person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * this method convert feilds of class to string.
     * @return string that contains first name & last name.
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
