package com;

import com.house.House;

import java.util.LinkedHashSet;
import java.util.Set;

public class City {
    private final Set<House> houses;
    private static int housesNumber;
    private String name;

    public City(String name){
        houses=new LinkedHashSet<>();
        this.name=name;
    }

    public boolean contains(House house){
        return houses.contains(house);
    }

    public void recountCitySize(){
        if(!houses.isEmpty())
            housesNumber = houses.size();
        else
            housesNumber = 0;
    }

    public void clearCity(){
        houses.clear();
        housesNumber=0;
    }

    public House getHouse(int number){
        for(House house : houses){
            if(house.getNumber()==number)
                return house;
        }
        return null;
    }

    public Set<House> getHouses(){
        return houses;
    }

    public boolean addHouse(House house){
        int size=houses.size();
        House[] houses1=new House[size];
        this.houses.toArray(houses1);
        for(int i=0;i<size;i++){
            if(house.getNumber()==houses1[i].getNumber())
                return false;
        }
        this.houses.add(house);
        ++housesNumber;
        return true;
    }

    public boolean deleteHouse(House house){
        int size=houses.size();
        House[] houses1=new House[size];
        this.houses.toArray(houses1);
        for(int i=0;i<size;i++){
            if(house.equals(houses1[i])) {
                houses.remove(house);
                --housesNumber;
                return true;
            }
        }
        return false;
    }

    public int getHousesNumber(){
        return housesNumber;
    }
}