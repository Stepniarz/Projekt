package com.company.Vehicles;


import com.company.Enums.brokenPart;
import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.Humans.Human;
import com.company.Interfaces.Buyable;
import com.company.Interfaces.Saleable;
import com.company.Humans.Player;
import com.company.Places.Garage;
import com.company.Places.Office;
import com.company.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

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
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", color=" + color +
                ", segment=" + segment +
                ", value=" + value +
                ", brokenPartsList=" + brokenPartsList +
                '}';
    }

    @Override
    public void sell(Player seller, Human buyer, double price, int carIndex) {
        if (seller.garage.carsOwned.contains(this) && buyer.cash >= price) {
            seller.cash += price;
            buyer.cash -= price;
            Office.transactionSell(this, buyer);
            seller.garage.carsOwned.remove(carIndex);

        } else {
            System.out.println("Client doesn't have enough money to afford this car or you dont own it");
        }
    }


}




