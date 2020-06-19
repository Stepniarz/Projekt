package com.company.Humans;

import com.company.Interfaces.Buyable;
import com.company.Interfaces.Saleable;
import com.company.Player;
import com.company.RandomNumberGenerator;
import com.company.Vehicles.Car;

import java.util.List;


public class CarDealer extends Human implements Buyable {
    public List<Car> listOfCarsToBuy;


    public CarDealer(String firstName, String lastName, double cash) {
        super(firstName, lastName, cash);
        this.listOfCarsToBuy = RandomNumberGenerator.getRandomCarList();
    }

    @Override
    public void buy(Player buyer, Double price,int carIndex) {
        if (buyer.cash >= price) {
            buyer.cash -= price;
            buyer.garage.ownedCars.add(listOfCarsToBuy.get(carIndex));
            this.listOfCarsToBuy.remove(carIndex);
            this.listOfCarsToBuy.add(RandomNumberGenerator.getRandomCar());
        } else {
            System.out.println("Client doesn't have enough money to afford this car or you dont own it");
        }
    }
}
