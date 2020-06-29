package com.company;

import com.company.Humans.*;
import com.company.Places.Garage;
import com.company.Places.Office;
import com.company.Vehicles.Car;

import java.io.IOException;
import java.util.Scanner;

import static com.company.Humans.CarDealer.listOfCarsToBuy;
import static com.company.Humans.CarDealer.showCarsAvailableForSale;
import static com.company.Menu.menuDisplay;
import static com.company.Menu.menuItems;
import static com.company.Menu.options;

public class Main {

    public static void main(String[] args) throws IOException {
            CarDealer.createListOfCarsAvailableForSale();
            int choice;
            int choiceOperation;
            //Menu display
            Player player = new Player("Player",20000);
            menuDisplay();
            //Scanner setup
            Scanner in = new Scanner(System.in);
            //User's choice
            choice = in.nextInt();
            //Menu display loop
            while (choice != options[options.length - 1]) {          //-1 ponieważ tablice zaczynają się od indeksu 0 a nie 1
                //User's input
                if (choice == options[0]) {
                    showCarsAvailableForSale();
                    System.out.println("Press enter to continue");
                    Scanner end = new Scanner(System.in);
                    System.in.read();

                } else if (choice == options[1]) {
                    showCarsAvailableForSale();
                    choiceOperation = in.nextInt();
                    if(choiceOperation > listOfCarsToBuy.size() && choiceOperation < 1 ){
                        System.out.println("There is no car with that index");
                    }else{
                        CarDealer.buy(player,choiceOperation);
                    }
                } else if (choice == options[2]) {
                    System.out.println(player.garage.carsOwned);
                } else if (choice == options[3]) {
                    System.out.println("Choose the car to repair");
                    System.out.println(player.garage.carsOwned);
                    choiceOperation = in.nextInt();
                    choiceOperation--;
                    if(choiceOperation > player.garage.carsOwned.size() && choiceOperation < 1 ){
                        System.out.println("There is no car with that index");
                        return;
                    }else{
                        System.out.println(player.garage.carsOwned.get(choiceOperation));
                    }
                    System.out.println("Choose the mechanic to repair chosen car");
                    Worker.showWorkers();
                    var choiceOperation2 = in.nextInt();
                    Worker.workerRepair(choiceOperation2,player.garage.carsOwned.get(choiceOperation),player);
                } else if (choice == options[4]) {
                    System.out.println(menuItems[4] + " przejrzyj potencjalnych klientów");
                } else if (choice == options[5]) {
                    System.out.println(menuItems[5] + " sprzedaj samochód za określoną cenę potencjalnemu klientowi");
                } else if (choice == options[6]) {
                    System.out.println(menuItems[6] + " kup reklamę");
                } else if (choice == options[7]) {
                    System.out.println("Your balance is: " + player.cash);
                } else if (choice == options[8]) {
                    System.out.println(menuItems[8] + " sprawdź historię transakcji");
                } else if (choice == options[9]) {
                    System.out.println(menuItems[9] + " sprawdź historię napraw każdego pojazdu");
                } else if (choice == options[10]) {
                    System.out.println(menuItems[10] + " sprawdź sumę kosztów napraw i mycia dla każdego z posiadanych pojazdów");
                } else {
                    System.out.println("Wrong answer, try again");
                }
                menuDisplay();
                choice = in.nextInt();
            }
            System.out.println("Bye :)");
        }
}
