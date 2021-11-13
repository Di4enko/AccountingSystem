package com.house;

import java.util.LinkedHashSet;

public class Apartment{
    private final double square;
    private final int tenants;
    private final int number;
    private static int counter=0;
    public final int MIN_SQR=10;//minimal sqr for per person

    protected Apartment(){
        square=10+Math.random()*50;
        tenants=(int)Math.floor(this.square/MIN_SQR);
        number =++counter;
    }

    protected Apartment(double square,int tenants){
        this.square=square;
        this.tenants=tenants;
        number=++counter;
    }

    public static void zeroingCounter(){
        counter=0;
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


