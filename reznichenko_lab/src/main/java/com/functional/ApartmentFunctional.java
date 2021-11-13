package com.functional;
import com.house.Apartment;
public class ApartmentFunctional {
    public static int compApartSqr(Apartment apartment1, Apartment apartment2){
        return Double.compare(apartment1.getSquare(), apartment2.getSquare());
    }

    public static int compApartTen(Apartment apartment1, Apartment apartment2) {
        return Integer.compare(apartment1.getTenants(), apartment2.getTenants());
    }
}
