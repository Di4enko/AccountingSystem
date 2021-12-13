package com;

import com.house.House;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTest {
    private static City city;
    private static House house1;
    private static House house2;
    private static House house3;

    @BeforeAll
    public static void setUp(){
        city=new City("Test");
        house1 = new House();
        house1.setNumber(1);
        house2 = new House();
        house2.setNumber(2);
        house3 = new House();
        house3.setNumber(3);
        city.getHouses().add(house1);
        city.getHouses().add(house2);
        city.getHouses().add(house3);
    }

    @Test
    public void addHouseTest(){
        House house=new House();
        int actualHousesNumber=city.getHousesNumber()+1;
        city.addHouse(house);
        int expectedHousesNumber=city.getHousesNumber();
        assertEquals(expectedHousesNumber,actualHousesNumber);
    }

    @Test
    public void deleteHouseTest(){
        int actualHousesNumber=city.getHousesNumber()-1;
        city.deleteHouse(house2);
        int expectedHousesNumber=city.getHousesNumber();
        assertEquals(expectedHousesNumber,actualHousesNumber);
    }

    @Test
    public void getHouseTest(){
        House actualHouse=house1;
        House expectedHouse= city.getHouse(1);
        assertEquals(actualHouse,expectedHouse);
    }
}
