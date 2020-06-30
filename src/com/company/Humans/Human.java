package com.company.Humans;

import com.company.Places.Garage;
import com.company.Vehicles.Car;

public class Human {
    public String firstName;
    public double cash;

    public Human(double cash){
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", cash=" + cash +
                '}';
    }
}
