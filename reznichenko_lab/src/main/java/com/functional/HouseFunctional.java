package com.functional;

import com.house.Apartment;
import com.house.Floor;
import com.house.House;

import java.io.IOException;

public class HouseFunctional {

    public static double countSqr(House house) throws IOException {
        if(house==null){
            throw new IOException();
        }
        double sqr=0;
        for(Floor floor: house.floors)
            for(Apartment apartment: floor.apartments){
                sqr+=apartment.getSquare();
            }
        return sqr;
    }

    public static int countTenants(House house) throws IOException{
        if(house== null){
            throw new IOException();
        }
        int tenants_count=0;
        for(Floor floor: house.floors)
            for(Apartment apartment: floor.apartments){
                tenants_count+=apartment.getTenants();
            }
        return tenants_count;
    }

    public static int countApartments(House house) throws IOException{
        if(house == null){
            throw new IOException();
        }
        int apartments_count=0;
        for(Floor floor: house.floors){
            apartments_count+= floor.apartments.size();
        }
        return apartments_count;
    }

    public static int compHouseSqr(House house1, House house2) throws IOException {
        return Double.compare(countSqr(house1), countSqr(house2));
    }

    public static int compHousePop(House house1, House house2) throws IOException {
        return Integer.compare(countTenants(house1), countTenants(house2));
    }

    public static int compHouseFlor(House house1, House house2) {
        return Integer.compare(house1.getFloors(), house2.getFloors());
    }

}
