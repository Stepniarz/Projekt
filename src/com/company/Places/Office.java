package com.company.Places;

import com.company.Humans.CarDealer;
import com.company.Humans.Client;
import com.company.Humans.Human;
import com.company.Humans.Player;
import com.company.Interfaces.Buyable;
import com.company.Interfaces.Saleable;
import com.company.Transaction;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;

public class Office {
    public static List<Transaction> transactionBuyList;
    public static List<Transaction> transactionSellList;
    //List of cars bought from CarDealer
    public static void transactionBuy(Car car, Player client){
        if(transactionBuyList == null){
            transactionBuyList = new ArrayList<Transaction>();
        }
        transactionBuyList.add(new Transaction(car,client));
    }
    //List of cars sold by player to the clients
    public static void  transactionSell(Car car,Human client){
        if(transactionSellList == null) {
            transactionSellList = new ArrayList<Transaction>();
        }
        transactionSellList.add(new Transaction(car,client));
    }
    public static void showBuyTransactions(){
        int i = 1;
        for (Transaction transaction : transactionBuyList) {
            System.out.println(i +". " + transaction);
            i++;
        }
    }
}


