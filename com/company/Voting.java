package com.company;

import java.util.*;

/**
 * this class contains information of a voting.
 * by this class we can add option to voting , print all people that took part in the voting ,
 * & we can manage that each person votes for the same option only once.
 *
 * @author   mahmood-saneian
 * @since    2021-4-12
 * @version  15-0-2
 */

public class Voting {
    //the type of voting
    private int type;
    //the question of voting
    private String question;
    //list of people that took part in the voting
    private ArrayList<Person> voters;
    //options & people that give a vote to each option.
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * this constructor initialize fields of class & allocate memory
     * to list of voters & map of options and people who give a vote to each optin.
     * @param type      the type of voting(can 0 or 1)
     * @param question  the question of voting.
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * this method return question of voting.
     * @return question of voting.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * this method add new option to voting.
     * @param newOption the option that we want add to voting.
     */
    public void createPoll(String newOption) {
        polls.put(newOption, new HashSet<Vote>());
    }

    /**
     * by this method   a person can give a vote & present in the voting.
     * @param person    a person who wants be present in voting.
     * @param voteCast  list of options that person wants give vote to.
     */
    public void vote(Person person, ArrayList<String> voteCast) {
        Iterator<String> it = voteCast.iterator();

        while (it.hasNext()) {
            String temp = it.next();
            if (checkRepeatition(person, temp) == true) {
                HashSet<Vote> votes = polls.get(temp);
                Vote vote = new Vote(person);
                votes.add(vote);
                addVoters(person);
            }
        }
    }

    /**
     * this method return type of voting to us.
     * @return type of voting.
     */
    public int getType() {
        return type;
    }

    /**
     * this method print all people that have been present in voting.
     */
    public void getVoters() {
        Iterator<Person> it = voters.iterator();

        while (it.hasNext()) {
            Person person = it.next();
            System.out.println(person);
        }
    }

    /**
     * this method print options & people who give a vote to each option.
     */
    public void printVotes() {
        Set entrySet = polls.entrySet();
        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * this method return options of voting.
     * @return options of voting.
     */
    public ArrayList<String> getPolls() {
        return new ArrayList<String>(polls.keySet());
    }

    /*
     * this method checks that whether a person has already voted for an option.
     * @param person a person who we checks.
     * @param key    an option that we checks.
     * @return       true or false.
     */
    private boolean checkRepeatition(Person person, String key) {

        HashSet<Vote> votes = polls.get(key);
        Iterator<Vote> it   = votes.iterator();

        while (it.hasNext()) {
            Person person1 = it.next().getPerson();
            if (person1.getFirstName().equals(person.getFirstName()) && person1.getLastName().equals(person.getLastName())) {
                System.out.println("cannot take a vote beacuse you have already voted to this option : "
                        + key);
                return false;
            }
        }
        return true;
    }

    /*
     * this method add a voter to list of voters.
     * @param person a person who we want add to list.
     * @return true if person doesn't exist in list & false if person does exist in list.
     */
    private boolean addVoters(Person person){
        Iterator<Person> it = voters.iterator();

        while (it.hasNext()){
            Person person1 = it.next();
            if (person1.getFirstName().equals(person.getFirstName()) && person1.getLastName().equals(person.getLastName()))
                return false;
        }
        voters.add(person);
        return true;
    }

    public HashMap<String, HashSet<Vote>> getpoll(){
        return polls;
    }
}
