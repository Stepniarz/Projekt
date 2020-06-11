package com.company.Humans;

import com.company.Vehicles.Car;


public class Worker extends Human {

    public Worker(String firstName, String lastName, double cash) {
        super(firstName, lastName, cash);
    }

    public void Repair(Car car){
        for (int i = 0; i < car.brokenPartsList.size(); i++){
            // TO DO LIST: chance to add, i jumps to 1, (Car car, double chance)
            switch (car.brokenPartsList.get(i)){
                case BREAKS:
                    car.value = car.value * 1.1;
                    break;
                case SUSPENSION:
                    car.value = car.value * 1.2;
                    break;
                case ENGINE:
                    car.value = car.value * 2;
                    break;
                case BODY:
                case TRANSMISSION:
                    car.value = car.value * 1.5;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + car.brokenPartsList.get(i));
            }
        }
        car.brokenPartsList.clear();

    }
}
