package com.house;

import java.util.LinkedHashSet;
import java.util.Set;

public class Floor {
    public Set<Apartment> apartments;
    protected static int number;

    protected Floor(int apartPerFloor) {
        apartments = new LinkedHashSet<>();
        for (int i = 0; i < apartPerFloor; i++) {

            Apartment apartment = new Apartment();
            apartments.add(apartment);
            ++number;
        }
    }
}