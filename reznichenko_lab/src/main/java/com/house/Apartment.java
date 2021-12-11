package com.house;

public class Apartment{
    private double square;
    private int tenants;
    private int number;
    private static int counter=0;
    public static final int MIN_SQR=10;//minimal sqr for per person

    public Apartment(){}

    public void setNumber(int number){
        this.number=number;
    }

    public void setSquare(double square){
        this.square=square;
    }

    public void setTenants(int tenants){
        this.tenants=tenants;
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

    public static void zeroingCounter(){
        counter=0;
    }

    public static void plusCounter(){
        ++counter;
    }

    public static int getCounter(){
        return counter;
    }

    public static Apartment createApartmentRandom() {
        Apartment.plusCounter();
        Apartment apartment = new Apartment();
        apartment.setSquare(Math.random() * 10 + 50);
        apartment.setNumber(Apartment.getCounter());
        apartment.setTenants((int) (apartment.getSquare() % Apartment.MIN_SQR));
        return apartment;
    }

    public static Apartment createApartmentWithParameters(double square, int tenants, int number) {
        Apartment apartment=new Apartment();
        apartment.setTenants(tenants);
        apartment.setSquare(square);
        apartment.setNumber(number);
        Apartment.plusCounter();
        return apartment;
    }
}


