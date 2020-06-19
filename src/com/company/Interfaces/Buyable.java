package com.company.Interfaces;


import com.company.Humans.CarDealer;
import com.company.Player;

public interface Buyable {
    public void buy(Player buyer, Double price,int carIndex);
}
