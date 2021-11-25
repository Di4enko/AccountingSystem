package com;

import com.house.Apartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentTest {

    @Test
    public void createApartmentWithParametersTest(){
        Apartment apartment=Apartment.createApartmentWithParameters(34,2,4);
        int[] actual={34,2,4};
        int[] expected = new int[3];
        expected[0]= (int) apartment.getSquare();
        expected[1]=apartment.getTenants();
        expected[2]=apartment.getNumber();
        Assertions.assertArrayEquals(actual,expected);
    }

    @Test
    public void createApartmentRandomTest(){
        Apartment apartment=Apartment.createApartmentRandom();
        boolean[] actual={true,true,true};
        boolean[] expected=new boolean[3];
        if(apartment.getNumber()!=0){
            expected[0]=true;
        }
        if(apartment.getSquare()!=0){
            expected[1]=true;
        }
        if(apartment.getTenants()!=0){
            expected[2]=true;
        }
        Assertions.assertArrayEquals(expected,actual);
    }
}
