package com;

import com.house.House;
import java.util.LinkedHashSet;
import java.util.Set;

public class City {
    public Set<House> houses;
    public static int housesNumber;

    public City(){
        houses=new LinkedHashSet<>();
    }

    public void citySize(){
        if(!houses.isEmpty())
            housesNumber = houses.size();
        else
            housesNumber = 0;
    }

    public House getHouse(int number){
        for(House house : houses){
            if(house.getNumber()==number)
                return house;
        }
        return null;
    }
}