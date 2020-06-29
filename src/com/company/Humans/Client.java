package com.company.Humans;

import com.company.Enums.brokenPart;
import com.company.Enums.carProducer;
import com.company.Enums.clientFirstName;
import com.company.Enums.clientWealth;
import com.company.Places.Garage;

import java.util.*;

import static com.company.RandomNumberGenerator.*;

public class Client extends Human {
    private final clientFirstName firstName;
    public List<carProducer> wantedCars;
    public double cash;
    Random r = new Random();
    private Set<carProducer> desiredProducer;
    private Set<brokenPart> acceptsBrokenCar;


    public Client(clientFirstName firstName, double cash) {
        super(cash);
        this.firstName = randomName();
        this.cash = assignClientCash(randomStatus());
        wantedCars = randomWantedProducersList();
    }
    //assigning client cash based on his wealth
    public static double assignClientCash(clientWealth clientWealth){
        switch(clientWealth){
            case POOR:
                return getRandomValue(1500,6500);
            case MEDIOCRE:
                return  getRandomValue(6500,20000);
            case WEALTHY:
                return getRandomValue(20000,800000);
            default:
                throw new IllegalArgumentException("Unexpected value" + clientWealth);
        }
    }

    }

