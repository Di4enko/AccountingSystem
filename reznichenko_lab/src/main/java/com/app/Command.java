package com.app;

import com.House;
import com.functional.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Command extends UserInterface{

    private Command(){
        throw new AssertionError();
    }

    private static void exit(){
        status=false;
    }

    private static void help(){
        System.out.println("Possible commands:");
        for(String command: commands)
            System.out.println(command);
    }

    private static void buildHouse(){
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Input a budget: ");
            double budget = in.nextDouble();
            System.out.print("Input a price for per square metre: ");
            double sqrMPrice = in.nextDouble();
            System.out.print("Input a number of apartments per floor: ");
            int apartments = in.nextInt();
            if(sqrMPrice!=0 && budget/sqrMPrice >= apartments && apartments!=0) {
                House house = new House(budget, sqrMPrice, apartments);
                city.houses.add(house);
                System.out.println("You build house");
            }else
                System.out.println("You cant build house with that parameters.");
        }catch (InputMismatchException e){
            System.err.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void deleteHouse() {
        System.out.print("Put houses number ");
        int number=in.nextInt();
        House house=city.getHouse(number);
        if(house!=null){
            for (House.Floor floor: house.floors) {
                floor.apartments.clear();
            }
            house.floors.clear();
            city.houses.remove(house);
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
                            System.out.printf("%d house has more number of tenants than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less number of tenants than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same number of tenants\n",number1,number2);

                    }
                    case (2) -> {
                        int i = HouseFunctional.compHouseSqr(house1,house2);
                        if (i == 1) {
                            System.out.printf("%d house has more square than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less square than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same square\n",number1,number2);
                    }
                    case (3) -> {
                        int i = HouseFunctional.compHouseFlor(house1,house2);
                        if (i == 1) {
                            System.out.printf("%d house has more numbers of floors than %d house\n",number1,number2);
                        } else if (i == -1) {
                            System.out.printf("%d house has less number of floors than %d house\n",number1,number2);
                        } else
                            System.out.printf("%d and %d houses have the same number of floors\n",number1,number2);
                    }
                    default -> System.err.println("The selected option does not exist");
                }
            } else
                System.err.println("One or both of the selected houses do not exist!");
        }catch (InputMismatchException e){
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
                                System.out.printf("%d apartment has less number of tenants than %d\n", apart1Number, apart2Number);
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
                                System.out.printf("The number of tenants of the %d apartment is larger than that of the %d\n", apart1Number, apart2Number);
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
            if(city.houses.contains(house)){
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
        } catch (InputMismatchException e) {
            System.err.println("Command stopped due to incorrect data entry!");
        }
    }

    private static void cityInformation(){
        System.out.println("Number of house is "+city.houses.size());
        if(!city.houses.isEmpty()) {
            System.out.print("House numbers are:\n");
            for (House house : city.houses)
                System.out.println("№" + house.getNumber() + " ");
        }
    }

    private static void clearCity(){
        city.houses.removeAll(city.houses);
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
                UserInterface.command=string;
                return;
            }
        UserInterface.command=null;
    }
}