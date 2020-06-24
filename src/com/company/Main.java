package com.company;

import com.company.Humans.*;
import com.company.Places.Garage;
import com.company.Places.Office;
import com.company.Vehicles.Car;

public class Main {

    public static void main(String[] args) {

     // Menu.Menu();

//        System.out.println((Car.getRandomColor()));
        Garage garage = new Garage();
       Car car = new Car(8000);
       Car car2 = new Car(8000);
       Car car3 = new Car(8000);
       Player player = new Player("Mateusz",10000.0);
       CarDealer cardi = new CarDealer("Milosz",8000);
    //  System.out.println("siema");
//        System.out.println(RandomNumberGenerator.finalValue);
      // System.out.println(car);
     //  Adrian.workerRepair(Adrian,car);
      // System.out.println("Po naprawie " + car);
        player.garage.carsOwned.add(car);
        player.garage.carsOwned.add(car2);
        player.garage.carsOwned.add(car3);
        player.garage.showCarsOwned();
        player.garage.showCarsAvailableForSale();
        System.out.println(Office.transactionBuyList);
//        System.out.println(player.garage.carsOwned);
//        System.out.println(cardi.listOfCarsToBuy.get(0));
//        System.out.println(cardi.listOfCarsToBuy.get(1));
        cardi.buy(player,6000.0,0);
        cardi.buy(player,1.0,1);
        Office.showBuyTransactions();
//        System.out.println("Kupiles auto");
//        System.out.println(player.garage.carsOwned);
//        System.out.println(cardi.listOfCarsToBuy.get(0));
    }
}
