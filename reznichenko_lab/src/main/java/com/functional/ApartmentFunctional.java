package com.functional;
import com.House;
public class ApartmentFunctional {
    public static int compApartSqr(House.Floor.Apartment apartment1, House.Floor.Apartment apartment2){
        return Double.compare(apartment1.getSquare(), apartment2.getSquare());
    }

    public static int compApartTen(House.Floor.Apartment apartment1, House.Floor.Apartment apartment2) {
        return Integer.compare(apartment1.getTenants(), apartment2.getTenants());
    }
}
