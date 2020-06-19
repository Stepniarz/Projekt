package com.company.Interfaces;

import com.company.Humans.Human;
import com.company.Player;

public interface Saleable {
    public void sell(Player seller, Human buyer, Double price);
}
