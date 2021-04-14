package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        outer:
        while (true) {

            menu();
            int input = scanner.nextInt();
            switch (input) {
                //create new voting
                case 1:
                    System.out.println("enter a question of voting");
                    String question = scanner.nextLine();
                    question = scanner.nextLine();
                    System.out.println("enter the type of voting");
                    int type = scanner.nextInt();
                    ArrayList<String> options = new ArrayList<String>();
                    while (true) {
                        System.out.println("enter the option of voting. to exit enter 1 otherwise enter 0");
                        int code = scanner.nextInt();
                        if (code == 1)
                            break;
                        String option = scanner.nextLine();
                        option = scanner.nextLine();
                        options.add(option);
                    }
                    votingSystem.createVoting(question, type, options);
                    break;

                case 2:
                    votingSystem.getVotingList();
                    break;

                case 3:
                    int index = scanner.nextInt();
                    votingSystem.getVoting(index);
                    break;
                case 4:
                    System.out.println("first , please enter index of voting");
                    index = scanner.nextInt();
                    if (index < votingSystem.getSize()) {
                        System.out.println("enter your first name");
                        String firstName = scanner.nextLine();
                        firstName = scanner.nextLine();
                        System.out.println("enter your last name");
                        String lastName = scanner.nextLine();
//                        lastName = scanner.nextLine();

                        Voting voting = votingSystem.findVoting(index);
                        System.out.println("options and question this voting : ");
                        votingSystem.getVoting(index);
                        Person person = new Person(firstName, lastName);
                        ArrayList<String> voteCast = new ArrayList<>();
                        if (voting.getType() == 0) {
                            System.out.println("enter option that you want take a vote.");
                            String option = scanner.nextLine();
//                            option = scanner.nextLine();
                            voteCast.add(option);
                        } else if (voting.getType() == 1) {
                            while (true) {
                                System.out.println("enter options that you want take a vote.enter 1 to finish otherwise enter 0");
                                int code = scanner.nextInt();
                                if (code == 1)
                                    break;
                                String option = scanner.nextLine();
                                option = scanner.nextLine();
                                voteCast.add(option);
                            }
                        }
                        votingSystem.vote(index,person,voteCast);
                    }
                    break;
                case 5:
                    index = scanner.nextInt();
                    votingSystem.getResult(index);
                    break;
                case 6:
                    System.out.println("enter the index of voting that want see voters");
                    index = scanner.nextInt();
                    Voting voting = votingSystem.findVoting(index);
                    voting.getVoters();
                    break;
                case 7:
                    System.out.println("enter index of voting");
                    index = scanner.nextInt();
                    voting = votingSystem.findVoting(index);
                    if (voting.getType() == 1){
                        System.out.println("you cannot use random vote because this is a multiple voting");
                    }else if (voting.getType() == 0){
                        System.out.println("enter first name");
                        String firstName = scanner.nextLine();firstName = scanner.nextLine();
                        System.out.println("enter last name");
                        String lastName  = scanner.nextLine();
                        Person person = new Person(firstName, lastName);

                        options = voting.getPolls();
                        Random random = new Random();
                        int index1 = random.nextInt(options.size());
                        ArrayList<String> voteCast = new ArrayList<String>();
                        voteCast.add(options.get(index1));
                        votingSystem.vote(index, person, voteCast);
                    }
                    break;
                case 8:
                    break outer;
            }

        }

    }

    public static void menu() {
        System.out.println("1.create new voting" + "\n" +
                "2.print all voting list" + "\n" +
                "3.print specifiec voting(enter index of voting that you want)" + "\n" +
                "4.give a vote" + "\n" +
                "5.get result of voting(enter index of voting)" + "\n" +
                "6.print voters of a voting" +"\n" +
                "7.random vote"+"\n"+
                "8.exit");
    }
}
