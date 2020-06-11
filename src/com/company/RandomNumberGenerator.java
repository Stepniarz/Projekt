package com.company;



import com.company.Vehicles.Car;

import java.util.Random;

public class RandomNumberGenerator {
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







}
