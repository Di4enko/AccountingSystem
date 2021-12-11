package com.functionalTest;

import com.functional.ApartmentFunctional;
import com.house.Apartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApartmentFunctionalTest {
    private Apartment apartment1;
    private Apartment apartment2;

    @BeforeEach
    public void setUp(){
        apartment1=new Apartment();
        apartment1.setNumber(1);
        apartment1.setTenants(4);
        apartment1.setSquare(30);
        apartment2=new Apartment();
        apartment2.setNumber(2);
        apartment2.setTenants(4);
        apartment2.setSquare(30);
    }

    @Test
    public void compApartSqrTest(){
        int[] expected={0,-1,1};
        int[] actual=new int[3];
        actual[0]= ApartmentFunctional.compApartSqr(apartment1,apartment2);
        apartment1.setSquare(35);
        actual[1]=ApartmentFunctional.compApartSqr(apartment2,apartment1);
        actual[2]=ApartmentFunctional.compApartSqr(apartment1,apartment2);
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void compApartTenTest(){
        int[] expected={0,-1,1};
        int[] actual=new int[3];
        actual[0]= ApartmentFunctional.compApartTen(apartment1,apartment2);
        apartment1.setTenants(5);
        actual[1]=ApartmentFunctional.compApartTen(apartment2,apartment1);
        actual[2]=ApartmentFunctional.compApartTen(apartment1,apartment2);
        Assertions.assertArrayEquals(expected,actual);
    }
}