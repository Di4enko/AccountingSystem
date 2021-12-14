package com.app;

import java.io.IOException;
import java.util.Scanner;
import com.City;
import com.FileController;

public class UserInterface {
    protected static boolean status;
    protected static Scanner in;
    protected static City city;
    protected static FileController fileController;

    public UserInterface(){
        status=true;
        in=new Scanner(System.in);
        System.out.println("Hello!\nEnter name for your new city: ");
        String name=in.next();
        city=new City(name);
        try {
            String path="D:\\Учеба\\программирование\\" +
                    "Java_projects\\AccountingSystem\\Cites\\"+name;
            fileController = new FileController(path);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Great! Enter 'help' to see the list of possible commands.");
    }

    protected boolean getStatus(){
        return  status;
    }

    protected void working(){
        String inputs = in.nextLine();
        if (!inputs.isBlank()) {
            Command.command(inputs);
            if (Command.getCommand() == null) {
                Command.accept();
            } else {
                System.err.println("Incorrect command!\nEnter help to see the list of possible commands.");
            }
        }
    }
}