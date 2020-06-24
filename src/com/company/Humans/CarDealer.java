package com.company.Humans;

import com.company.Interfaces.Buyable;
import com.company.Places.Garage;
import com.company.Places.Office;
import com.company.RandomNumberGenerator;
import com.company.Transaction;
import com.company.Vehicles.Car;

import java.util.List;


public class CarDealer extends Human implements Buyable {
    public List<Car> listOfCarsToBuy;


    public CarDealer(String firstName, double cash) {
        super(cash);
        this.firstName = firstName;
        this.listOfCarsToBuy = RandomNumberGenerator.getRandomCarList();
    }

    @Override
    public void buy(Player buyer,double price,int carIndex) {
        if (buyer.cash >= price) {
            buyer.cash -= price;
            buyer.garage.carsOwned.add(listOfCarsToBuy.get(carIndex));
            Office.transactionBuy(listOfCarsToBuy.get(carIndex),buyer);
            this.listOfCarsToBuy.remove(carIndex);
            this.listOfCarsToBuy.add(RandomNumberGenerator.getRandomCar());
        } else {
            System.out.println("Client doesn't have enough money to afford this car");
        }
    }
}
