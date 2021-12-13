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

    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj instanceof House){
            if(!(((House) obj).number == this.number))
                return false;
            if(!(((House) obj).floorsNumber == this.floorsNumber))
                return false;
            if(!(((House) obj).floors.size()==this.floors.size()))
                return false;
            int size=this.floors.size();
            Floor[] apartments1 = new Floor[size];
            this.floors.toArray(apartments1);
            Floor[] apartments2=new Floor[size];
            ((House)obj).floors.toArray(apartments2);
            for(int i=0;i<size;i++){
                if(!(apartments1[i].equals(apartments2[i])))
                    return false;
            }
        }
        return false;
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