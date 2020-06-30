package com.company;

import com.company.Humans.*;
import com.company.Places.Garage;
import com.company.Places.Office;
import com.company.Vehicles.Car;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.company.Humans.CarDealer.listOfCarsToBuy;
import static com.company.Humans.CarDealer.showCarsAvailableForSale;
import static com.company.Menu.*;

public class Main {

    public static void main(String[] args) throws IOException {
        CarDealer.createListOfCarsAvailableForSale();
        List<Client> listOfClients = RandomNumberGenerator.getRandomClientList();
        int choice;
        int choiceOperation;
        //Menu display
        Player player = new Player("Player", 20000);
        menuDisplay();
        //Scanner setup
        Scanner in = new Scanner(System.in);
        //User's choice
        choice = in.nextInt();
        //Menu display loop
        while (choice != options[options.length - 1]) {          //-1 ponieważ tablice zaczynają się od indeksu 0 a nie 1
            //User's input
            if (choice == options[0]) {
                CarDealer.showCarsAvailableForSale();
                System.out.println("Press enter to continue");
                System.in.read();

            } else if (choice == options[1]) {
                CarDealer.showCarsAvailableForSale();
                System.out.println("Pick the car you want to buy");
                choiceOperation = in.nextInt();
                if (choiceOperation > listOfCarsToBuy.size() && choiceOperation < 1) {
                    System.out.println("There is no car with that index");
                } else {
                    CarDealer.buy(player, choiceOperation);
                    turnCounter++;
                }
            } else if (choice == options[2]) {
                System.out.println(player.garage.carsOwned);
            } else if (choice == options[3]) {
                if (player.garage.carsOwned.size() == 0) {
                    System.out.println("Your garage is empty");
                } else {
                    System.out.println("Choose the car to repair");
                    player.garage.showCarsOwned();
                    choiceOperation = in.nextInt();
                    choiceOperation--;
                    if (choiceOperation >= player.garage.carsOwned.size() || choiceOperation < 0) {
                        System.out.println("There is no car with that index");
                    } else {
                        System.out.println(player.garage.carsOwned.get(choiceOperation));
                        System.out.println("Choose the mechanic to repair chosen car");
                        Worker.showWorkers();
                        var choiceOperation2 = in.nextInt();
                        Worker.workerRepair(choiceOperation2, player.garage.carsOwned.get(choiceOperation), player);
                        turnCounter++;
                    }
                }
            } else if (choice == options[4]) {
                int i = 1;
                for (Client client : listOfClients) {
                    System.out.println(i + ". " + client.toString());
                    i++;
                }
            } else if (choice == options[5]) { // sprzedaj samochód za określoną cenę potencjalnemu klientowi
                player.garage.checkForNewCarsForSale();
                if (player.garage.carsAvailableForSale.size() == 0) {
                    System.out.println("You don't have any cars you can sell. Buy or repair them first");
                } else {
                    System.out.println("Pick the car you want to sell");
                    player.garage.showCarsAvailableForSale();
                    choiceOperation = in.nextInt();
                    choiceOperation--;
                    if (choiceOperation >= player.garage.carsAvailableForSale.size() || choiceOperation < 0) {
                        System.out.println("Wrong car index");
                    } else {
                        System.out.println(player.garage.carsAvailableForSale.get(choiceOperation));
                        System.out.println("Choose the client you want to sell that car");
                        int i = 1;
                        for (Client client : listOfClients) {
                            System.out.println(i + ". " + client.toString());
                            i++;
                        }
                        int choiceOperation2;
                        do {
                            choiceOperation2 = in.nextInt();
                            choiceOperation2--;
                            if (!listOfClients.get(choiceOperation2).wantedCars.contains(player.garage.carsAvailableForSale.get(choiceOperation).producer)) {
                                System.out.println("This person is not interested in this car");
                            } else {
                                System.out.println("Pick a price");
                                var chosenPrice = in.nextDouble();
                                player.garage.carsAvailableForSale.get(choiceOperation).sell(player, listOfClients.get(choiceOperation2), chosenPrice, choiceOperation);
                                listOfClients.add(RandomNumberGenerator.getRandomClient());
                                listOfClients.add(RandomNumberGenerator.getRandomClient());
                                turnCounter++;
                            }
                        } while (choiceOperation2 > listOfClients.size() && choiceOperation2 < 0);
                    }
                }

            } else if (choice == options[6]) {
                System.out.println("You advertise your company in a local newspaper (cost: 1500)");
                listOfClients.addAll(Advertisement.advertisementNewspaper(player));
                turnCounter++;
            } else if (choice == options[7]) {
                System.out.println("Your balance is: " + player.cash);
            } else if (choice == options[8]) {
                System.out.println("Bought cars: ");
                Office.showBuyTransactions();
                System.out.println("Sold cars: ");
                Office.showSellTransactions();
            } else if (choice == options[9]) {
                Office.showRepairs();
            } else if (choice == options[10]) {
                System.out.println(player.moneySpentOnPrepair);
            } else {
                System.out.println("Wrong answer, try again");
            }
            if (Menu.gameEnd(player) == false) {
                menuDisplay();
                choice = in.nextInt();
            }
        }
        System.out.println("Bye :)");
    }
}
