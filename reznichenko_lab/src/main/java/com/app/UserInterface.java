package com.app;

import java.util.Scanner;

import com.City;

public class UserInterface {
    protected static boolean status;
    protected static Scanner in;
    protected static City city;
    protected final static String[] commands={"build house","delete house","compare houses",
            "compare apartments","house information","city information", "clear city", "help", "exit"};
    protected static String command;

    public UserInterface(){
        status=true;
        in=new Scanner(System.in);
        city=new City();
        System.out.println("Hello!\nEnter 'help' to see the list of possible commands.");
    }

    protected boolean getStatus(){
        return  status;
    }

    protected void working(){
            String inputs = in.nextLine();
            if (!inputs.isBlank()) {
                Command.command(inputs);
                if (command!= null) {
                    Command.accept();
                } else {
                    System.err.println("Incorrect command!\nEnter help to see the list of possible commands.");
                }
            }
        }
    }
