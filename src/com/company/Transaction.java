package com.company;

import com.company.Humans.Client;
import com.company.Humans.Human;
import com.company.Vehicles.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    public Car car;
    public Human client;
    public Date dateOfTransaction;

    public Transaction(Car car, Human client) {
        this.car = car;
        this.client = client;
        this.dateOfTransaction = new java.util.Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "car=" + car +
                ", client=" + client +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }
}

