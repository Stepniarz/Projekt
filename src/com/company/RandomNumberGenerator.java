package com.company;


import com.company.Enums.*;
import com.company.Humans.Client;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static final Random r = new Random();

    public static int numberCheck(double possibilty) {
        int numberOfParts = -1; // if set to 0 there will always be one broken part
        double chance;
        do {
            chance = Math.random();
            numberOfParts++;
        }
        while (chance < possibilty);
        return numberOfParts;
    }

    public static int getRandomValue(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException(("Max value needs to be greater than minimum"));
        } else {
            Random randomValue = new Random();
            return randomValue.nextInt((max - min) + 1) + min;
        }
    }

    public static carProducer randomProducer() {
        int pickRandomProducer = r.nextInt(carProducer.values().length);
        return carProducer.values()[pickRandomProducer];
    }

    public static carColor randomColor() {
        int pickRandomColor = r.nextInt(carColor.values().length);
        return carColor.values()[pickRandomColor];
    }

    public static clientFirstName randomName() {
        int pickRandomName = r.nextInt(clientFirstName.values().length);
        return clientFirstName.values()[pickRandomName];
    }
    public static clientWealth randomStatus(){
        int pickRandomStatus = r.nextInt(clientWealth.values().length);
        return clientWealth.values()[pickRandomStatus];
    }
    //Is this ok?
    public static brokenPart randomBrokenPart() {
        int pickRandomPart = r.nextInt(brokenPart.values().length);
        return brokenPart.values()[pickRandomPart];
    }

    public static carSegment randomSegment() {
        int pickRandomSegment = r.nextInt(carSegment.values().length);
        return carSegment.values()[pickRandomSegment];
    }

    public static Car getRandomCar(){
        return new Car(getRandomValue(0,400000));
    }
    //List of randomly generated cars, unavailable for player to see
    public static List<Car> getRandomCarList() {
        List<Car> listToReturn = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listToReturn.add(getRandomCar());
        }
        return listToReturn;
    }

    //List of randomly generated broken parts
    public static List<brokenPart> getRandomParts() {
        List<brokenPart> listToReturn = new ArrayList<>();
        int numberOfBrokenParts = RandomNumberGenerator.numberCheck(0.60);
        Random rand = new Random();
        for (int i = 0; i < numberOfBrokenParts; i++) {
            brokenPart partToAdd = brokenPart.values()[rand.nextInt(5)];
            if (!listToReturn.contains(partToAdd))
                listToReturn.add(partToAdd);
        }
        return listToReturn;
    }
}


