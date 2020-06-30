package com.company.Vehicles;


import com.company.Enums.brokenPart;
import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.Humans.Human;
import com.company.Interfaces.Saleable;
import com.company.Humans.Player;
import com.company.Places.Office;
import com.company.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car extends RandomNumberGenerator implements Saleable {
    public carProducer producer;
    public String model;
    public double mileage;
    public carColor color;
    public carSegment segment;
    public double value;
    public List<brokenPart> brokenPartsList = new ArrayList<>();

    //Enums


    public Car(double mileage) {
        this.producer = randomProducer();
        this.segment = randomSegment();
        this.value = assignCarValue(segment);
        this.mileage = mileage;
        this.color = randomColor();
        this.brokenPartsList = getRandomParts();

    }

    //assigning car value based on segment
    private double assignCarValue(carSegment carSegment) {
        switch (carSegment) {
            case PREMIUM:
                return getRandomValue(10000, 25000);
            case STANDARD:
                return getRandomValue(5000, 9999);
            case BUDGET:
                return getRandomValue(800, 4999);
            default:
                throw new IllegalStateException("Unexpected value: " + carSegment);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", mileage=" + mileage +
                ", color=" + color +
                ", segment=" + segment +
                ", value=" + value +
                ", brokenPartsList=" + brokenPartsList +
                '}';
    }

    @Override
    public void sell(Player seller, Human buyer, double price, int carIndex) {
        if (seller.garage.carsAvailableForSale.contains(this) && buyer.cash >= price) {
            seller.moneySpentOnPrepair += price * 0.02;
            seller.cash -= seller.moneySpentOnPrepair;
            seller.cash += price;
            buyer.cash -= price;
            Office.transactionSell(this, buyer);
            seller.garage.carsOwned.remove(carIndex);
            seller.garage.carsAvailableForSale.remove(carIndex);
            System.out.println("Car washed and sold successfully");
        } else {
            System.out.println("Client doesn't have enough money to afford this car or you dont own it");
        }
    }


}




