package com.company.Humans;

import com.company.Places.Garage;

public class Player extends Human {
    public Garage garage;

    public Player(String firstName, double cash) {
        super(cash);
        this.garage = new Garage();
    }

}
