package com.functionalTest;

import com.functional.HouseFunctional;
import com.house.Apartment;
import com.house.Floor;
import com.house.House;
import org.junit.jupiter.api.*;
import  static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class HouseFunctionalTest {
    private static House house;

    @BeforeAll
    public static void setUp(){
        house =new House();
        Floor floor1=new Floor();
        Floor floor2=new Floor();
        Floor floor3=new Floor();
        floor1.apartments.add(Apartment.createApartmentWithParameters(37,3,1));
        floor1.apartments.add(Apartment.createApartmentWithParameters(45,1,2));
        floor2.apartments.add(Apartment.createApartmentWithParameters(50,5,3));
        floor2.apartments.add(Apartment.createApartmentWithParameters(32,5,4));
        floor3.apartments.add(Apartment.createApartmentWithParameters(41,2,5));
        floor3.apartments.add(Apartment.createApartmentWithParameters(26,3,6));
        house.floors.add(floor1);
        house.floors.add(floor2);
        house.floors.add(floor3);
        house.setFloorsNumber(3);
    }

    @Test
    public  void countSqrTest() throws IOException {
        double expected= HouseFunctional.countSqr(house);
        double actual = 231;
        assertEquals(expected,actual);
    }

    @Test
    public void countTenantsTest() throws IOException {
        int expected = HouseFunctional.countTenants(house);
        int actual = 19;
        assertEquals(expected,actual);
    }

    @Test
    public void countApartmentsTest() throws IOException {
        int expected = HouseFunctional.countApartments(house);
        int actual = 6;
        assertEquals(expected,actual);
    }

    @Test
    public void countFloorsTest() throws IOException {
        int expected=HouseFunctional.countFloors(house);
        int actual=3;
        assertEquals(expected,actual);
    }

    @Nested
    class CompMethodsTest{
        private static House house2;

        @BeforeEach
        public void innerSetUp() throws IOException{
            house2 =new House();
            Floor floor1=new Floor();
            Floor floor2=new Floor();
            Floor floor3=new Floor();
            floor1.apartments.add(Apartment.createApartmentWithParameters(37,3,1));
            floor1.apartments.add(Apartment.createApartmentWithParameters(45,1,2));
            floor2.apartments.add(Apartment.createApartmentWithParameters(50,5,3));
            floor2.apartments.add(Apartment.createApartmentWithParameters(32,5,4));
            floor3.apartments.add(Apartment.createApartmentWithParameters(41,2,5));
            floor3.apartments.add(Apartment.createApartmentWithParameters(26,3,6));
            house2.floors.add(floor1);
            house2.floors.add(floor2);
            house2.floors.add(floor3);
            house2.setFloorsNumber(3);
        }

        @Test
        public  void compHouseSqrTest() throws IOException {
            int[] actual={0,-1,1};
            int[] expected=new int[3];
            Floor floor = null;
            for(Floor floor1:house2.floors){
                floor=floor1;
            }
            expected[0]=HouseFunctional.compHouseSqr(house, house2);
            house2.floors.remove(floor);
            expected[1]=HouseFunctional.compHouseSqr(house2, house);
            expected[2]=HouseFunctional.compHouseSqr(house,house2);
            Assertions.assertArrayEquals(expected,actual);
        }

        @Test
        public  void compHousePopTest() throws IOException {
            int[] actual={0,-1,1};
            int[] expected=new int[3];
            Floor floor = null;
            for(Floor floor1:house2.floors){
                floor=floor1;
            }
            expected[0]=HouseFunctional.compHousePop(house, house2);
            house2.floors.remove(floor);
            expected[1]=HouseFunctional.compHousePop(house2, house);
            expected[2]=HouseFunctional.compHousePop(house,house2);
            Assertions.assertArrayEquals(expected,actual);
        }

        @Test
        public  void compHouseFloorTest() throws IOException {
            int[] actual={0,-1,1};
            int[] expected=new int[3];
            Floor floor = null;
            for(Floor floor1:house2.floors){
                floor=floor1;
            }
            expected[0]=HouseFunctional.compHouseFloor(house, house2);
            house2.floors.remove(floor);
            house2.setFloorsNumber(HouseFunctional.countFloors(house2));
            expected[1]=HouseFunctional.compHouseFloor(house2, house);
            expected[2]=HouseFunctional.compHouseFloor(house,house2);
            Assertions.assertArrayEquals(expected,actual);
        }
    }
}
