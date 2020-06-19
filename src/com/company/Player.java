package com.company;

import com.company.Interfaces.Buyable;
import com.company.Humans.CarDealer;
import com.company.Places.Garage;
import com.company.Vehicles.Car;

import java.util.Scanner;

public class Player  {
    public String nickName;
    public double cash;
    public Garage garage;
    Scanner scan = new Scanner(System.in);

    public Player(double cash) {
        this.nickName = scan.nextLine();
        this.cash = cash;
    }




}
