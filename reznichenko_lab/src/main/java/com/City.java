package com;

import java.util.LinkedHashSet;

public class City {
    public LinkedHashSet<House> houses;
    public static int housesNumber;
    public City(){
        houses=new LinkedHashSet<>();
    }

    protected void clearCity(){
        if(!houses.isEmpty()){
            houses.clear();

        }
    }

    protected int citySize(){
        if(!houses.isEmpty())
            return houses.size();
        else
            return 0;
    }

    public House getHouse(int number){
        for(House house : houses){
            if(house.getNumber()==number)
                return house;
        }
        return null;
    }
}
