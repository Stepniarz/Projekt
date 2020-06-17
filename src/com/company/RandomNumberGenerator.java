package com.company;



import com.company.Enums.brokenPart;
import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static final Random r = new Random();

    public static int numberCheck(double possibilty) {
        int numberOfParts = -1; // if set to 0 there will always be one broken part
        double chance;
        do{
            chance = Math.random();
            numberOfParts++;
        }
        while(chance < possibilty);
        return numberOfParts;
    }
    public static int getRandomValue(int min,int max){
        if (min >= max) {
            throw new IllegalArgumentException(("Max value needs to be greater than minimum"));
        }
        else{
            Random randomValue = new Random();
            return randomValue.nextInt((max-min)+1)+min;
        }
    }
    public carProducer randomProducer(){
        int pickRandomProducer = r.nextInt(carProducer.values().length);
        return carProducer.values()[pickRandomProducer];
    }
    public carColor randomColor(){
        int pickRandomColor = r.nextInt(carColor.values().length);
        return carColor.values()[pickRandomColor];
    }
    //Is this ok?
    public static brokenPart randomBrokenPart(){
        int pickRandomPart = r.nextInt(brokenPart.values().length);
        return  brokenPart.values()[pickRandomPart];
    }
    public carSegment randomSegment(){
        int pickRandomSegment = r.nextInt(carSegment.values().length);
                return carSegment.values()[pickRandomSegment];
    }
    public List<brokenPart> getRandomParts() {
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

}
