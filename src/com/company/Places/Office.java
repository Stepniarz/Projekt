package com.company.Places;

import com.company.Humans.Human;
import com.company.Humans.Player;
import com.company.Humans.Worker;
import com.company.Repair;
import com.company.Transaction;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;

public class Office {
    public static List<Transaction> transactionBuyList;
    public static List<Transaction> transactionSellList;
    public static List<Repair> repairList;

    //List of cars bought from CarDealer
    public static void transactionBuy(Car car, Player client) {
        if (transactionBuyList == null) {
            transactionBuyList = new ArrayList<Transaction>();
        }
        transactionBuyList.add(new Transaction(car, client));
    }

    //List of cars sold by player to the clients
    public static void transactionSell(Car car, Human client) {
        if (transactionSellList == null) {
            transactionSellList = new ArrayList<Transaction>();
        }
        transactionSellList.add(new Transaction(car, client));
    }

    public static void repairedList(Car car, Worker mechanic) {
        if (repairList == null) {
            repairList = new ArrayList<Repair>();
        }
        repairList.add(new Repair(car, mechanic));
    }

    public static void showBuyTransactions() {
        if (transactionBuyList == null) {
            System.out.println("You haven't bought anything yet");
        } else {
            int i = 1;
            for (Transaction transaction : transactionBuyList) {
                System.out.println(i + ". " + transaction);
                i++;
            }
        }
    }

    public static void showSellTransactions() {
        if (transactionSellList == null) {
            System.out.println("You haven't sold anything yet");
        } else {
            int i = 1;
            for (Transaction transaction : transactionSellList) {
                System.out.println(i + ". " + transaction);
                i++;
            }
        }
    }

    public static void showRepairs() {
        if (repairList == null) {
            System.out.println("You haven't repaired anything yet");
        }else {
            int i = 1;
            for (Repair repair : repairList) {
                System.out.println(i + ". " + repair);
                i++;
            }
        }
    }
}


