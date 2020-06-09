package com.company.Vehicles;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car{
    public double value;
    public String producer;
    public String model;
    public double mileage;
    public String color;
    public String segment;
    public List<brokenPart> brokenPartsList = new ArrayList<>();
    //Enums
    private static final brokenPart[] BROKEN_PARTS = brokenPart.values();
    private static final carProducer[] CAR_PRODUCER = carProducer.values();
    private static final carColor[] CAR_COLOR = carColor.values();
    private static final int PARTS_AMOUNT = BROKEN_PARTS.length;
    private static final int PRODUCERS_AMOUNT = CAR_PRODUCER.length;
    private static final int COLORS_AMOUNT = CAR_COLOR.length;





    public Car(String producer, String model, double value, double mileage, String color, String segment){
        this.producer = producer;
        this.model = model;
        this.value = value;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.brokenPartsList = getRandomParts();

    }
    //Broken parts of the vehicle
    public enum brokenPart{
        BREAKS(1),
        SUSPENSION(2),
        ENGINE(3),
        BODY(4),
        TRANSMISSION(5);

        int value;
        brokenPart(int i) {
            this.value = i;
        }
        public int getBrokenPartIndex(){
            return this.value;
        }
    }
    public enum carProducer{
        VOLVO,
        OPEL,
        FIAT,
        TOYOTA,
        RENO
    }
    public enum carColor{
        WHITE,
        BLACK,
        BLUE,
        YELLOW,
        GREEN,
        SILVER,
        BROWN,
        RED,
        PINK,
        PURPLE,
    }

    private List<brokenPart> getRandomParts() {
            List<brokenPart> listToReturn = new ArrayList<>();
            int numberOfBrokenParts = numberCheck(0.35);
            Random rand = new Random();
            for (int i = 0;i < numberOfBrokenParts ;i++){
                brokenPart partToAdd = brokenPart.values()[rand.nextInt(5)];
                if(!listToReturn.contains(partToAdd))
                    listToReturn.add(partToAdd);
            }
            return listToReturn;
        }
//    private carProducer getRandomProducer () {
//        return CAR_PRODUCER[RANDOM.nextInt((PRODUCERS_AMOUNT))];
//    }
//    private carColor getRandomColor () {
//        return CAR_COLOR[RANDOM.nextInt((COLORS_AMOUNT))];
//    }

    private int numberCheck(double possibilty) {
        int numberOfParts = -1;
        double chance;
        do{
            chance = Math.random();
            numberOfParts++;
        }
        while(chance < possibilty);
        return numberOfParts;
    }
    }




