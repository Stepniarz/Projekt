package com.company.Humans;

import com.company.Places.Office;
import com.company.RandomNumberGenerator;
import com.company.Vehicles.Car;

import java.util.List;


public class CarDealer extends Human {
    public static List<Car> listOfCarsToBuy;


    public  CarDealer(String firstName, double cash) {
        super(cash);
    }

    public static void createListOfCarsAvailableForSale(){
        if(listOfCarsToBuy == null){
            listOfCarsToBuy = RandomNumberGenerator.getRandomCarList();
        }
    }
    public static void showCarsAvailableForSale(){
        int i = 1;
        for (Car car : listOfCarsToBuy) {
            System.out.println(i + ". " + car);
            i++;
        }
    }


    public static void buy(Player buyer,int carIndex ) {
        carIndex--; //-- so car index will match with player's input
        if (buyer.cash >= listOfCarsToBuy.get(carIndex).value) {
            buyer.cash -= listOfCarsToBuy.get(carIndex).value;
            buyer.garage.carsOwned.add(listOfCarsToBuy.get(carIndex));
            Office.transactionBuy(listOfCarsToBuy.get(carIndex),buyer);
            System.out.println(listOfCarsToBuy.get(carIndex) + "has been added to your garage");
            listOfCarsToBuy.remove(carIndex);
            listOfCarsToBuy.add(RandomNumberGenerator.getRandomCar());
        } else {
            System.out.println("Client doesn't have enough money to afford this car");
        }
    }
}
