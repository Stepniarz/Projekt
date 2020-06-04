package com.company;

import com.company.Humans.Human;

import java.util.Scanner;

public final class Menu {
    static int[] options= {1,2,3,4,5,6,7,8,9,10,11,12};
    static String[] menuItems={"Cars available for purchase","Buy a car","Your cars","Repair your car","Client list","Sell your car","Advertising",
            "Account balance","List of transactions","List of repairs","Money spent on preparing cars for sale","Exit game"};
    private static Menu instance;

    private Menu(){

    }
    //singleton
    public static Menu getInstance(){
        if (instance == null)
            instance = new Menu();
        return instance;
    }

    public static void menuDisplay(){
        System.out.println("MAIN MENU");
        System.out.println("================================================");
        //Option and Items loop
        for(int i = 0; i < options.length; i++){
            System.out.printf("%d. %s\n", options[i], menuItems[i]);
        }
        System.out.println("================================================");
        System.out.print("Enter your choice:");
    }
    public static void Menu() {
        int choice;
        //Menu display
       menuDisplay();
        //Scanner setup
        Scanner in = new Scanner(System.in);
        //User's choice
        choice = in.nextInt();
        //Menu display loop
        while(choice != options[options.length - 1]) {          //-1 ponieważ tablice zaczynają się od indeksu 0 a nie 1
            //User's input
            if (choice == options[0]) {
                System.out.println(menuItems[0] + " is still in development" );
            }
            else if (choice == options[1]) {
                System.out.println(menuItems[1] + " is still in development");
            }
            else if (choice == options[2]) {
                System.out.println(menuItems[2] + " is still in development");
            }
            else if (choice == options[3]) {
                System.out.println(menuItems[3] + " is still in development");
            }
            else if (choice == options[4]) {
                System.out.println(menuItems[4] + " is still in development");
            }
            else if (choice == options[5]) {
                System.out.println(menuItems[5] + " is still in development");
            }
            else if (choice == options[6]) {
                System.out.println(menuItems[6] + " is still in development");
            }
            else if (choice == options[7]) {
                System.out.println(menuItems[7] + " is still in development");
            }
            else if (choice == options[8]) {
                System.out.println(menuItems[8] + " is still in development");
            }
            else if (choice == options[9]) {
                System.out.println(menuItems[9] + " is still in development");
            }
            else if (choice == options[10]) {
                System.out.println(menuItems[10] + " is still in development");
            }
            else {
                System.out.println("Wrong answer, try again");
            }
          menuDisplay();
            choice = in.nextInt();
        }
        System.out.println("Bye :)");
    }
}
