package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ShowResult {
    private HashMap<String, HashSet<Vote>> polls;


    public ShowResult(HashMap<String, HashSet<Vote>> polls) {
        this.polls = polls;
    }

    public void showResult() {
        int total = 0;
        for (String key : polls.keySet()){
            total+= polls.get(key).size();
        }

        for (String key : polls.keySet()) {
            double percent = takePercentage(polls.get(key).size(), total);
            System.out.println(key + " : " + percent + " , " + polls.get(key).size());
        }
    }


    private double takePercentage(int number, int total) {
        return ((double) number / total) * 100;
    }
}
