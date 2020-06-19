package com.company;

import com.company.Enums.carColor;
import com.company.Enums.carProducer;
import com.company.Enums.carSegment;
import com.company.Humans.CarDealer;
import com.company.Humans.Client;
import com.company.Humans.Human;
import com.company.Humans.Worker;
import com.company.Vehicles.Car;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.company.Humans.Worker.Adrian;

public class Main {

    public static void main(String[] args) {

     // Menu.Menu();

//        System.out.println((Car.getRandomColor()));
       Car car = new Car(8000);
       Player player = new Player(90900);
       CarDealer cardi = new CarDealer("Milosz","Ksajo",5);
    //  System.out.println("siema");
////        System.out.println(RandomNumberGenerator.finalValue);
//       // System.out.println(car);
//      //  Adrian.workerRepair(Adrian,car);
//       // System.out.println("Po naprawie " + car);
        System.out.println(player.car);
        System.out.println(cardi.listOfCarsToBuy.get(0));
        System.out.println(cardi.listOfCarsToBuy.get(1));
        cardi.buy(player,6000.0,0);
        System.out.println("Kupiles auto");
        System.out.println(player.car);
        System.out.println(cardi.listOfCarsToBuy.get(0));
    }
}
