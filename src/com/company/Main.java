package com.company;

import com.company.Humans.Human;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        //Menu display
        System.out.println("MAIN MENU");
        System.out.println("================================================");
        System.out.println("1. Cars available for purchase");
        System.out.println("2. Buy a car");
        System.out.println("3. Your cars");
        System.out.println("4. Repair your car");
        System.out.println("5. Client list");
        System.out.println("6. Sell your car");
        System.out.println("7. Advertising");
        System.out.println("8. Account balance");
        System.out.println("9. List of transactions");
        System.out.println("10. List of repairs");
        System.out.println("11. Money spent on preparing cars for sale");
        System.out.println("12. Exit game");
        System.out.println("================================================");
        System.out.print("Enter your choice:");
        //Scanner setup
        Scanner in = new Scanner(System.in);
        //User's choice
        choice = in.nextInt();
        //Menu display loop
        while(choice != 12) {
            //User's input
            if (choice == 1) {
                System.out.println("Cars available for purchase is still in development");
            }
            else if (choice == 2) {
                System.out.println("Buy a car is still in development");
            }
            else if (choice == 3) {
                System.out.println("Your cars is still in development");
            }
            else if (choice == 4) {
                System.out.println("Repair your car is still in development");
            }
            else if (choice == 5) {
                System.out.println("Client list is still in development");
            }
            else if (choice == 6) {
                System.out.println("Sell your car is still in development");
            }
            else if (choice == 7) {
                System.out.println(" Advertising is still in development");
            }
            else if (choice == 8) {
                System.out.println("Account balance is still in development");
            }
            else if (choice == 9) {
                System.out.println("List of transactions is still in development");
            }
            else if (choice == 10) {
                System.out.println("List of repairs is still in development");
            }
            else if (choice == 11) {
                System.out.println("Money spent on preparing cars for sale is still in development");
            }
            else {
                System.out.println("Wrong answer, try again");
            }
            System.out.println("MAIN MENU");
            System.out.println("================================================");
            System.out.println("1. Cars available for purchase");
            System.out.println("2. Buy a car");
            System.out.println("3. Your cars");
            System.out.println("4. Repair your car");
            System.out.println("5. Client list");
            System.out.println("6. Sell your car");
            System.out.println("7. Advertising");
            System.out.println("8. Account balance");
            System.out.println("9. List of transactions");
            System.out.println("10. List of repairs");
            System.out.println("11. Money spent on preparing cars for sale");
            System.out.println("12. Exit game");
            System.out.println("================================================");
            System.out.print("Enter your choice:");
            choice = in.nextInt();
        }







        Human me = new Human("Mateusz","Stępiński",10000.0);

    }
}
