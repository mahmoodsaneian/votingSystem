package com.company;

import java.util.ArrayList;

/**
 * the "VotingSystem" class manage polls.
 * by this class we can create a new voting , see result of voting ,
 * see list of all voting , see question and options of a poll & a person can give a vote.
 *
 * @author   mahmood-saneian
 * @since    2021-4-12
 * @version  15.0.2
 */

public class VotingSystem {
    //list of exist votings
    private ArrayList<Voting> votingList;

    /**
     * this constructor , allocate memory for votingList
     */
    public VotingSystem() {
        votingList = new ArrayList<Voting>();
    }

    /**
     * this method create a new voting & adds it to list of voting.
     * @param question the question of voting.
     * @param type     the type of voting(if type == 0 -> single voting , if type == 1 -> multiple voting).
     * @param options  this is list of voting's option.
     */
    public void createVoting(String question, int type, ArrayList<String> options){
        Voting voting = new Voting(type , question);
        votingList.add(voting);
        for (String s : options)
            voting.createPoll(s);
    }

    /**
     * this method print questions of all exist votings.
     */
    public void getVotingList() {
        for (Voting voting : votingList)
            System.out.println(voting.getQuestion());
    }

    /**
     * this method get index of a voting & find it in the list.
     * then , print question and options this voting.
     * @param index index of voting in list of voting.
     */
    public void getVoting(int index){
        Voting voting = votingList.get(index);
        ArrayList<String> options = voting.getPolls();
        System.out.println(voting.getQuestion());
        for (String s : options)
            System.out.println(s);
    }

    /**
     * by this method user can give a vote to a option or multiple options.
     * @param index     index of voting in list of votings.
     * @param person    profile of the person that give a vote.
     * @param voteCasts list of options that person a person votes for.this list contain one or more options.
     */
    public void vote(int index, Person person, ArrayList<String> voteCasts){
        Voting voting = votingList.get(index);
        voting.vote(person , voteCasts);
    }

    /**
     * this method takes the voting index and prints the result.
     * @param index this is index of voting in list of votings.
     */
    public void getResult(int index){
        Voting voting = votingList.get(index);
        voting.printVotes();
    }

    /**
     * this method  find a voting by using index of voting.
     * @param index index of voting in list of votings.
     * @return the voting that we want.
     */
    public Voting findVoting(int index){
        return votingList.get(index);
    }

    /**
     * this method return number of voting that exist in the list.
     * @return number of votings that exist in the list.
     */
    public int getSize(){
        return votingList.size();
    }

}
