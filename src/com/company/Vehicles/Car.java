package com.company.Vehicles;


import com.company.Enums.brokenPart;
import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car extends RandomNumberGenerator{
    public carProducer producer;
    public String model;
    public double mileage;
    public carColor color;
    public carSegment segment;
    public double value;
    public List<brokenPart> brokenPartsList = new ArrayList<>();
    //Enums
    private static final brokenPart[] BROKEN_PARTS = brokenPart.values();
    private static final carProducer[] CAR_PRODUCER = carProducer.values();
    private static final carColor[] CAR_COLOR = carColor.values();
    private static final int PRODUCERS_AMOUNT = CAR_PRODUCER.length;
    private static final int COLORS_AMOUNT = CAR_COLOR.length;
    

    public Car(carProducer producer, String model,double mileage, carColor color,carSegment segment){
        this.producer = producer;
        this.model = model;
        this.segment = segment;
        this.value = assignCarValue(segment);
        this.mileage = mileage;
        this.color = color;
        this.brokenPartsList = getRandomParts();

    }
    private List<brokenPart> getRandomParts() {
            List<brokenPart> listToReturn = new ArrayList<>();
            int numberOfBrokenParts = RandomNumberGenerator.numberCheck(0.60);
            Random rand = new Random();
            for (int i = 0;i < numberOfBrokenParts ;i++){
                brokenPart partToAdd = brokenPart.values()[rand.nextInt(5)];
                if(!listToReturn.contains(partToAdd))
                    listToReturn.add(partToAdd);
            }
            return listToReturn;
        }

        private double assignCarValue(carSegment carSegment){
        switch (carSegment){
            case PREMIUM:
                return getRandomValue(10000,25000);
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
    //    private carProducer getRandomProducer () {
//        return CAR_PRODUCER[RANDOM.nextInt((PRODUCERS_AMOUNT))];
//    }
//    private carColor getRandomColor () {
//        return CAR_COLOR[RANDOM.nextInt((COLORS_AMOUNT))];
//    }

    }




