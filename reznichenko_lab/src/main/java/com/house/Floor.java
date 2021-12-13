package com.house;

import java.util.LinkedHashSet;
import java.util.Set;

public class Floor {
    public Set<Apartment> apartments;

    public Floor() {
        apartments = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj instanceof Floor){
            if(!(((Floor) obj).apartments.size()==this.apartments.size()))
                return false;
            int size=this.apartments.size();
            Apartment[] apartments1 = new Apartment[size];
            this.apartments.toArray(apartments1);
            Apartment[] apartments2=new Apartment[size];
            ((Floor)obj).apartments.toArray(apartments2);
            for(int i=0;i<size;i++){
                if(!(apartments1[i].equals(apartments2[i])))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static Floor floor() {
        Floor floor=new Floor();
        floor.apartments = new LinkedHashSet<>();
        return floor;
    }
}