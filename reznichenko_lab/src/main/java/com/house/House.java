package com.house;

import java.util.LinkedHashSet;
import java.util.Set;

public class House{
    private int number;
    private int floorsNumber;
    private static int counter=0;
    public Set<Floor> floors;

    public House(){
        floors=new LinkedHashSet<>();
    }

    public void setNumber(int number){
        this.number=number;
    }

    public void setFloorsNumber(int floorsNumber){
        this.floorsNumber=floorsNumber;
    }

    public int getNumber() {
        return number;
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

    public static int getCounter(){
        return counter;
    }

    public static void plusCounter(){
        ++counter;
    }

    public static void zeroingCounter(){
        counter=0;
    }
}