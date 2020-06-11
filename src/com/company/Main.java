package com.company;

import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.Humans.Human;
import com.company.Humans.Worker;
import com.company.Vehicles.Car;

import java.awt.*;
import java.util.Scanner;

public class Main extends RandomNumberGenerator {

    public static void main(String[] args) {
     // Menu.Menu();
//        System.out.println(Car.getRandomProducer());
//        System.out.println((Car.getRandomColor()));
        Car car = new Car(carProducer.VOLVO,"s90",1000.0, carColor.BLACK, carSegment.STANDARD);
        Worker worker = new Worker("Ja","awe",100.0);
//        System.out.println(car.brokenPartsList);
//        System.out.println(RandomNumberGenerator.finalValue);
        System.out.println(car);
        worker.Repair(car);
        System.out.println("Po naprawie " + car);
    }
}
