package com.company;

import com.company.Humans.CarDealer;
import com.company.Humans.Human;
import com.company.Humans.Player;

import java.util.Scanner;

import static com.company.Humans.CarDealer.showCarsAvailableForSale;

public final class Menu {
    static int[] options = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static String[] menuItems = {"Cars available for purchase", "Buy a car", "Your cars", "Repair your car", "Client list", "Sell your car", "Advertising",
            "Account balance", "List of transactions", "List of repairs", "Money spent on preparing cars for sale", "Exit game"};
    private static Menu instance;
    static int turnCounter;

    private Menu() {

    }

    //singleton
    public static Menu getInstance() {
        if (instance == null)
            instance = new Menu();
        return instance;
    }

    public static void menuDisplay() {
        turnCounter++;
        System.out.println("MAIN MENU");
        System.out.println("================================================");
        //Option and Items loop
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s\n", options[i], menuItems[i]);
        }
        System.out.println("================================================");
        System.out.println("Turn: " + turnCounter);
        System.out.print("Enter your choice:");
    }
    public static boolean gameEnd(Player player) {
        if (player.cash >= 40000) {
            System.out.println("You won!");
            System.out.println("It only took you: " + turnCounter + "turns! congratulations!!!");
            System.exit(0);
            return true;

        }
        if (player.cash < 0) {
            System.out.println("You lost. Try again");
            System.out.println("Losing in just " + turnCounter + "turns? Quite sad isn't it?");
            System.exit(0);
            return true;
        }
        return false;
    }
    }

