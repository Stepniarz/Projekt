package com.company.Vehicles;

import java.util.Random;

public class Car {
    public double value;
    public String producer;
    public String model;
    public double mileage;
    public String color;
    public String segment;
    //Enums
    private static final brokenParts[] BROKEN_PARTS = brokenParts.values();
    private static final carProducer[] CAR_PRODUCER = carProducer.values();
    private static final carColor[] CAR_COLOR = carColor.values();
    private static final int PARTS_AMOUNT = BROKEN_PARTS.length;
    private static final int PRODUCERS_AMOUNT = CAR_PRODUCER.length;
    private static final int CAR_COLORS = CAR_COLOR.length;
    private static final Random RANDOM = new Random();



    public Car(String producer, String model, double value, double mileage, String color, String segment){
        this.producer = producer;
        this.model = model;
        this.value = value;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
    }
    //Randomly picked broken parts of the vehicle
    public enum brokenParts{
        BREAKS,
        SUSPENSION,
        ENGINE,
        BODY,
        TRANSMISSION
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
    public static brokenParts getRandomPart(){
        return BROKEN_PARTS[RANDOM.nextInt(PARTS_AMOUNT)];
    }
    public static carProducer getRandomProducer(){
        return  CAR_PRODUCER[RANDOM.nextInt((PRODUCERS_AMOUNT))];
    }
    public static carColor getRandomColor(){
        return CAR_COLOR[RANDOM.nextInt((CAR_COLORS))];
    }
}

    //


