package com.house;

import com.functional.HouseFunctional;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class House{
    private final int number;
    private final int floorsNumber;
    private static int counter=0;
    public Set<Floor> floors;

    public House(double budget, double perSqrMPrice, int apartPerFloor) throws IOException {
        floors=new LinkedHashSet<>();
        double planHouseSqr = Math.ceil(budget / perSqrMPrice);
        while (planHouseSqr - HouseFunctional.countSqr(this) > 0) {
            Floor floor = new Floor(apartPerFloor);
            floors.add(floor);
        }
        if(planHouseSqr< HouseFunctional.countSqr(this)) {
            floors.remove(floors.size() - 1);
        }
        this.number=++counter;
        this.floorsNumber =floors.size();
        Apartment.zeroingCounter();
    }

    public Apartment getApartment(int number){
        for(Floor floor: floors)
            for(Apartment apartment: floor.apartments)
                if(number==apartment.getNumber())
                    return apartment;
        return null;
    }

    public int getFloors() {
        return floorsNumber;
    }

    public int getNumber() {
        return number;
    }

    public static void zeroingCounter(){
        counter=0;
    }
}