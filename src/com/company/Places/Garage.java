package com.company.Places;

import com.company.Humans.Human;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    public List<Car> carsOwned;
    public  List<Car> carsAvailableForSale;
    public Garage(){
        this.carsOwned = new ArrayList<Car>();
        this.carsAvailableForSale = new ArrayList<Car>();
    }

    public void showCarsOwned(){
        for(Car car : carsOwned){
            System.out.println(car);
        }
    }

    public void showCarsAvailableForSale() {
        for (Car car: carsAvailableForSale) {
                System.out.println(car);
            }
        }

    public void checkForNewCarsForSale(){
        for(Car car: carsOwned){
            if(car.brokenPartsList.size() == 0){
                if(!carsAvailableForSale.contains(car)){
                    carsAvailableForSale.add(car);
                }
            }
        }
    }


    //Bought cars
    //Waiting for repair
    //Ready to sell
}
