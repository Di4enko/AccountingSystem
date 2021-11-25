package com.house;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import com.functional.HouseFunctional;

public class HouseBuilder {
    private static final Scanner in = new Scanner(System.in);

    public static House createRandomHouse() throws IOException {
        System.out.print("Input a budget: ");
        double budget = in.nextDouble();
        System.out.print("Input a price for per square metre: ");
        double sqrMPrice = in.nextDouble();
        System.out.print("Input a number of apartments per floor: ");
        int apartmentsPerFloor = in.nextInt();
        if (sqrMPrice != 0 && budget / sqrMPrice >= apartmentsPerFloor && apartmentsPerFloor != 0) {
            House house = new House();
            double planSqr = budget / sqrMPrice;
            do {
                Floor floor = Floor.floor();
                for (int i = 0; i < apartmentsPerFloor; i++) {
                    floor.apartments.add(Apartment.createApartmentRandom());
                }
                house.floors.add(floor);
            } while (HouseFunctional.countSqr(house) < planSqr);
            House.plusCounter();
            house.setNumber(House.getCounter());
            house.setFloorsNumber(HouseFunctional.countFloors(house));
            System.out.println("You build house!");
            Apartment.zeroingCounter();
            return house;
        }else
            System.out.println("You cant build house with that parameters.");
        return null;
    }

    public static House createHouseWithParameters() throws IOException {
        House house=new House();
        System.out.println("Input number of floors");
        int floors= in.nextInt();
        house.setFloorsNumber(floors);
        house.floors=new LinkedHashSet<>();
        for(int i=1;i<=floors;i++){
            Floor floor=Floor.floor();
            System.out.printf("Input number of apartments on the %d floor\n",i);
            int apartmentsNumber=in.nextInt();
            for(int j=1;j<=apartmentsNumber;j++)
            {
                System.out.printf("Input square for the %d apartment\n",j);
                int square=in.nextInt();
                System.out.printf("Input number of tenants for the %d apartment\n",j);
                int tenants=in.nextInt();
                System.out.printf("Input number for the %d apartment\n",j);
                int number=in.nextInt();
                Apartment apartment=Apartment.createApartmentWithParameters(square,tenants,number);
                floor.apartments.add(apartment);
            }
            house.floors.add(floor);
        }
        House.plusCounter();
        house.setNumber(House.getCounter());
        System.out.println("You build house!");
        Apartment.zeroingCounter();
        return house;
    }
}
