package com.company.Humans;

import com.company.Enums.brokenPart;
import com.company.Enums.carProducer;
import com.company.RandomNumberGenerator;

import java.util.Set;

public class Client extends Human {
    private Set<carProducer> desiredProducer;
    private Set<brokenPart> acceptsBrokenCar;


    public Client(String firstName, String lastName, double cash){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = RandomNumberGenerator.getRandomValue(1000,10000);
    }


}
