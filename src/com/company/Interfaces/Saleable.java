package com.company.Interfaces;

import com.company.Humans.Human;
import com.company.Humans.Player;

public interface Saleable {
    public void sell(Player seller, Human buyer, double price,int carIndex);
}
