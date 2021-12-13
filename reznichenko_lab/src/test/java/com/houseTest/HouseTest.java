package com.houseTest;

import com.house.Apartment;
import com.house.Floor;
import com.house.House;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseTest {

    @Test
    public void getApartmentTest(){
        House house =new House();
        Floor floor1=new Floor();
        Floor floor2=new Floor();
        Floor floor3=new Floor();
        Apartment actualApartment=Apartment.createApartmentWithParameters(50,5,3);
        floor1.apartments.add(Apartment.createApartmentWithParameters(37,3,1));
        floor1.apartments.add(Apartment.createApartmentWithParameters(45,1,2));
        floor2.apartments.add(actualApartment);
        floor2.apartments.add(Apartment.createApartmentWithParameters(32,5,4));
        floor3.apartments.add(Apartment.createApartmentWithParameters(41,2,5));
        floor3.apartments.add(Apartment.createApartmentWithParameters(26,3,6));
        house.floors.add(floor1);
        house.floors.add(floor2);
        house.floors.add(floor3);
        house.setFloorsNumber(3);
        Apartment expectedApartment=house.getApartment(3);
        assertEquals(expectedApartment,actualApartment);
    }
}
