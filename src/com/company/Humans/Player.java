package com.company.Humans;

import com.company.Humans.Human;
import com.company.Interfaces.Buyable;
import com.company.Humans.CarDealer;
import com.company.Places.Garage;
import com.company.Vehicles.Car;

import java.util.Scanner;

public class Player extends Human {
    public Garage garage;

    public Player(String firstName, double cash) {
        super(cash);
        this.garage = new Garage();
    }

}
