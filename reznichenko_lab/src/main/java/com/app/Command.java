package com.app;

import com.house.*;
import com.functional.*;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public class Command extends UserInterface{
    private static String command;
    private final static String[] commands={"build house","delete house","compare houses",
            "compare apartments","house information","city information", "clear city", "help", "exit"};

    private Command(){
        throw new AssertionError();
    }

    public static String getCommand(){
        return command;
    }

    private static void exit(){
        File file=new File(fileController.getMainPath());
        if(file.exists()) {
            if(file.delete()){
                System.out.println("Empty city deleted.");
            }
        }
        status=false;
    }

    private static void help(){
        System.out.println("Possible commands:");
        for(String command: commands)
            System.out.println(command);
    }

    private static void buildHouse(){
        try {
            System.out.println("If you want to build a house based on its budget input 'random'.\n" +
                    "If you want to build a house with manual input of parameters input 'parameters'.");
            String methode=in.nextLine();
            if(methode.equals("random")){
                House house=HouseBuilder.createRandomHouse();
                city.addHouse(house);
                fileController.saveHouse(house);
            }
            else if(methode.equals("parameters")){
                House house=HouseBuilder.createHouseWithParameters();
                city.addHouse(house);
                fileController.saveHouse(house);}
            else System.out.println("This methode does not exist");
        }catch (InputMismatchException | IOException e){
            System.err.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void deleteHouse() {
        System.out.print("Put houses number ");
        int number=in.nextInt();
        House house=city.getHouse(number);
        if(house!=null){
            for (Floor floor: house.floors) {
                floor.apartments.clear();
            }
            house.floors.clear();
            city.deleteHouse(house);
            System.out.println("You delete house №"+number);
        }
        else
            System.err.println("The selected house does not exist!");
    }

    private static void compareHouses()  {
        try {
            System.out.println("Put houses numbers:");
            int number1 = in.nextInt();
            int number2 = in.nextInt();
            System.out.println("""
                    Select a parameter and enter its number
                    1.Tenants
                    2.Square
                    3.Floors""");
            int parameter = in.nextInt();
            House house1 = city.getHouse(number1);
            House house2 = city.getHouse(number2);
            if (house1 != null && house2 != null) {
                switch (parameter) {
                    case (1) -> {
                        int i = HouseFunctional.compHousePop(house1,house2);
                        if (i == 1) {
                            System.out.printf("%d house has more tenants than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less tenants than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same number of tenants\n",number1,number2);

                    }
                    case (2) -> {
                        int i = HouseFunctional.compHouseSqr(house1,house2);
                        if (i == 1) {
                            System.out.printf("%d house has larger square than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less square than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same square\n",number1,number2);
                    }
                    case (3) -> {
                        int i = HouseFunctional.compHouseFloor(house1,house2);
                        if (i == 1) {
                            System.out.printf("%d house has more floors than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less floors than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same number of floors\n",number1,number2);
                    }
                    default -> System.err.println("The selected option does not exist");
                }
            } else
                System.err.println("One or both of the selected houses do not exist!");
        }catch (InputMismatchException | IOException e){
            System.err.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void compareApartments(){
        try {
            System.out.print("Put house number:");
            int houseNumber = in.nextInt();
            House house = city.getHouse(houseNumber);
            System.out.print("Put apartments numbers:");
            int apart1Number = in.nextInt() - 1;
            int apart2Number = in.nextInt() - 1;
            System.out.println("""
                    Select a parameter and enter its number
                    1.Square
                    2.Tenants""");
            int parameter = in.nextInt();
            if (house != null) {
                switch (parameter) {
                    case (1) -> {
                        try {
                            int i = ApartmentFunctional.compApartSqr(house.getApartment(apart1Number),house.getApartment(apart2Number));
                            if (i == 1) {
                                System.out.printf("The square of the %d apartment is larger than that of the %d\n", apart1Number, apart2Number);
                            } else if (i == -1) {
                                System.out.printf("%d apartment has less square than %d\n", apart1Number, apart2Number);
                            } else
                                System.out.printf("%d and %d apartments have the same square\n", apart1Number, apart2Number);
                        } catch (InputMismatchException e) {
                            System.err.println("The selected apartments do not exist!");
                        }
                    }
                    case (2) -> {
                        try {
                            int i = ApartmentFunctional.compApartTen(house.getApartment(apart1Number),house.getApartment(apart2Number));
                            if (i == 1) {
                                System.out.printf("Number of tenants of the %d apartment is larger than that of the %d\n", apart1Number, apart2Number);
                            } else if (i == -1) {
                                System.out.printf("%d apartment has less number of tenants than %d\n", apart1Number, apart2Number);
                            } else
                                System.out.printf("%d and %d apartments have the same number of tenants\n", apart1Number, apart2Number);
                        } catch (InputMismatchException e) {
                            System.err.println("One or both of the selected apartments do not exist!");
                        }
                    }
                    default -> System.err.println("The selected option does not exist");
                }
            } else
                System.out.println("The selected house does not exist!");
        }catch(InputMismatchException e){
            System.out.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void houseInformation() {
        try {
            System.out.print("Put houses number:");
            int number = in.nextInt();
            House house = city.getHouse(number);
            if(city.contains(house)){
                System.out.print("""
                        Chose parameter:
                        1.Number
                        2.Square
                        3.Population
                        4.Floors
                        5.Apartments
                        6.All information
                        """);
                int parameter = in.nextInt();
                switch (parameter) {
                    case (1) -> System.out.println("Number: " + house.getNumber());
                    case (2) -> System.out.println("Square: " + HouseFunctional.countSqr(house));
                    case (3) -> System.out.println("Population: " + HouseFunctional.countTenants(house));
                    case (4) -> System.out.println("Floors: " + house.getFloors());
                    case (5) -> System.out.println("Apartments: " + HouseFunctional.countApartments(house));
                    case (6) -> {
                        System.out.println("Number: " + house.getNumber());
                        System.out.println("Square: " + HouseFunctional.countSqr(house));
                        System.out.println("Population: " + HouseFunctional.countTenants(house));
                        System.out.println("Floors: " + house.getFloors());
                        System.out.println("Apartments: " + HouseFunctional.countApartments(house));
                    }
                }
            } else {
                System.err.println("Selected house does not exist!");
            }
        } catch (InputMismatchException | IOException e) {
            System.err.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void cityInformation(){
        city.recountCitySize();
        System.out.println("Number of house is "+ city.getHousesNumber());
        if(city.getHousesNumber()!=0) {
            System.out.print("House numbers are:\n");
            for (House house : city.getHouses())
                System.out.println("№" + house.getNumber() + " ");
        }
    }

    private static void clearCity(){
        city.clearCity();
        House.zeroingCounter();
        System.out.println("You deleted all houses!");
    }

    protected static void accept(){
        switch (command) {
            case ("build house") -> buildHouse();
            case ("delete house") -> deleteHouse();
            case ("compare houses") -> compareHouses();
            case ("compare apartments") -> compareApartments();
            case ("house information") -> houseInformation();
            case ("city information") -> cityInformation();
            case ("clear city") -> clearCity();
            case ("help") -> help();
            case ("exit") -> exit();
        }
    }

    public static void command(String command){
        for(String string: commands)
            if(command.equalsIgnoreCase(string)){
                Command.command =string;
                return;
            }
        Command.command=null;
    }
}