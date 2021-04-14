package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.Objects;

/**
 * this class create a vote & contains date of voting and characteristics
 * of people who give a vote.
 *
 * @author    mahmood-saneian.
 * @since     2021-4-12.
 * @version   15.0.2
 */

public class Vote {
    //characteristics of a person
    private Person person;
    //date that give a vote
    private String date;

    JalaliCalendar calendar = new JalaliCalendar();

    /**
     * this constructor takes characteristics of person who give a vote & specifies date of voting.
     * @param person the characteristics of person who give a vote.
     */
    public Vote(Person person) {
        this.person = person;
        this.date = calendar.toString();
    }

    /**
     * this method return characteristics of person who give a vote.
     * @return return characteristics of person who give a vote.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * this method return date of voting.
     * @return date of voting.
     */
    public String getDate() {
        return date;
    }

    /**
     * this method checks equality two vote.
     * @param o objects that we checks equality.
     * @return true or false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vote))
            return false;

        Vote vote = (Vote) o;

        return getPerson().equals(vote.getPerson()) && getDate().equals(vote.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerson(), getDate());
    }

    /**
     * this method convert fields to string.
     * @return string that contain fields of class.
     */
    @Override
    public String toString() {
        return "Vote{" +
                "person=" + person +
                ", date='" + date + '\'' +
                '}';
    }
}
