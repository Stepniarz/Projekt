package com.company;

import com.company.Humans.Worker;
import com.company.Vehicles.Car;

import java.util.Date;

public class Repair {
    public Car car;
    public Worker mechanic;
    public Date dateOfRepair;

    public Repair(Car car, Worker mechanic){
        this.car = car;
        this.mechanic = mechanic;
        this.dateOfRepair = new java.util.Date();
    }

    @Override
    public String toString() {
        return "Repair{" +
                "car: " + car +
                ", by: " + mechanic +
                ", dateOfRepair=" + dateOfRepair +
                '}';
    }
}
