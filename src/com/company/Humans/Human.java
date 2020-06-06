package com.company.Humans;

public class Human {
    public String firstName;
    public String lastName;
    public double cash;

    public Human(String firstName, String lastName, double cash){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }
    Human Janusz = new Human("Janusz","Nowak",3000.0);
    Human Marian = new Human("Marian","Kowalski",2500.0);
    Human Adrian = new Human("Adrian","Kowonowak",150.0);

}
