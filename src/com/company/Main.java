package com.company;

import com.company.Humans.Human;
import com.company.Vehicles.Car;

import java.awt.*;
import java.util.Scanner;

public class Main extends RandomNumberGenerator {

    public static void main(String[] args) {
     // Menu.Menu();
//        System.out.println(Car.getRandomProducer());
//        System.out.println((Car.getRandomColor()));
        Car car = new Car("Volvo","Peugot",5600.0,115000.0,"Purple","Tak");
        System.out.println(car.brokenPartsList);
        System.out.println(RandomNumberGenerator.finalValue);
    }
}
