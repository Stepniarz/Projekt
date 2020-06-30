package com.company;

import com.company.Humans.Client;
import com.company.Humans.Player;

import java.util.ArrayList;
import java.util.List;

public class Advertisement {
    public Client client;

    public Advertisement (Client client){
        this.client = client;
    }
    public static List<Client> advertisementNewspaper(Player player){
        List<Client> listToReturn = new ArrayList<>();
        if (player.cash >= 1500){
            player.cash -= 1500;
        }for(int i = 0; i < RandomNumberGenerator.getRandomValue(1,8); i++){
            listToReturn.add(RandomNumberGenerator.getRandomClient());
        }
        return listToReturn;
    }
}
