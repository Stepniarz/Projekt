package com.company.Vehicles;

public class Car {
    public double value;
    public String producer;
    public String model;
    public double mileage;
    public String color;
    public String segment;



    public Car(String producer, String model, double value, double mileage, String color, String segment){
        this.producer = producer;
        this.model = model;
        this.value = value;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
    }
}
