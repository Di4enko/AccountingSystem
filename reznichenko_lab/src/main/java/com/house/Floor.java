package com.house;

import java.util.LinkedHashSet;
import java.util.Set;

public class Floor {
    public Set<Apartment> apartments;

    public Floor() {
        apartments = new LinkedHashSet<>();
    }

    public static Floor floor() {
        Floor floor=new Floor();
        floor.apartments = new LinkedHashSet<>();
        return floor;
    }
}