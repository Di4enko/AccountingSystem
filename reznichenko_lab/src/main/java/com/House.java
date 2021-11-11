package com;

import com.functional.HouseFunctional;

import java.util.LinkedHashSet;

public class House{
    private final int number;
    private final int floorsNumber;
    private static int counter=0;
    public LinkedHashSet<Floor> floors;

    public class Floor{
        public LinkedHashSet<Apartment> apartments;
        protected static int number;
        public class Apartment{
            private final double square;
            private final int tenants;
            private final int number;
            private static int counter=0;
            public final int MIN_SQR=10;//minimal sqr for per person


            protected Apartment(){
                this.square=10+Math.random()*50;
                this.tenants=(int)Math.floor(this.square/MIN_SQR);
                this.number =++counter;
            }

            public int getTenants(){
                return tenants;
            }

            public double getSquare() {
                return square;
            }

            public int getNumber() {
                return number;
            }
                    }

        protected Floor(int apartPerFloor){
            apartments=new LinkedHashSet<>();
            for(int i=0;i<apartPerFloor;i++) {

                Apartment apartment = new Apartment();
                apartments.add(apartment);
                ++number;
            }
        }
    }

    public House(double budget, double perSqrM, int apartPerFloor) {
        floors=new LinkedHashSet<>();
        double planHouseSqr = Math.ceil(budget / perSqrM);
        while (planHouseSqr - HouseFunctional.countSqr(this) > 0) {
            Floor floor = new Floor(apartPerFloor);
            floors.add(floor);
        }
        if(planHouseSqr< HouseFunctional.countSqr(this)) {
            floors.remove(floors.size() - 1);
        }
        this.number=++counter;
        this.floorsNumber =floors.size();
        Floor.Apartment.counter=0;
    }

    public Floor.Apartment getApartment(int number){
        int returnNumber=0;
        for(Floor floor: floors)
            for(Floor.Apartment apartment: floor.apartments)
                if(number==apartment.getNumber())
                    return apartment;
        return null;
    }

    public int getFloors() {
        return this.floorsNumber;
    }

    public int getNumber() {
        return number;
    }

    public static void zeroingCounter(){
        counter=0;
    }
}