package com.company.Humans;

import com.company.Enums.brokenPart;
import com.company.RandomNumberGenerator;
import com.company.Vehicles.Car;


public class Worker extends Human {
    public double repairChance;
    public double repairCost;
    private double damagingPartChance;
    boolean successfulRepair;

    public Worker(String firstName, String lastName, double cash, double repairCost, double damagingPartChance) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.repairCost = repairCost;
        this.damagingPartChance = damagingPartChance;
    }

    public static Worker Janusz = new Worker("Janusz", "Kowalski", 5000, 1, 0);
    public static Worker Marian = new Worker("Marian", "Wilk", 4500, 0.9, 0);
    public static Worker Adrian = new Worker("Adrian", "Nowak", 3000, 0.8, 0.02);

    public boolean workerRepairChance(Worker worker, Car car) {
        int chance = RandomNumberGenerator.getRandomValue(0, 100);
        System.out.println(chance);
        if (worker == Janusz) {
            successfulRepair = true;
            repairCost = Janusz.repairCost;
            System.out.println("Janusz naprawia");
        }
        if (worker == Marian) {
            if (chance <= 90) {
                successfulRepair = true;
                repairCost = Marian.repairCost;
            } else {
                successfulRepair = false;
                workerRepairChance(Janusz, car);
                repairCost = Marian.repairCost + Janusz.repairCost;
            }
        }
        if (worker == Adrian) {
            brokenPart newBrokenPart;
            if (chance >= 98) {
                if (car.brokenPartsList.size() < brokenPart.values().length) {
                    do {
                        newBrokenPart = RandomNumberGenerator.randomBrokenPart();
                    }
                    while (car.brokenPartsList.contains(newBrokenPart));
                    car.brokenPartsList.add(newBrokenPart);
                    System.out.println("Adrian znowu popsul");
                }
                else
                    System.out.println("Nie da sie bardziej popsuc auta");
            }
            if (chance <= 80) {
                successfulRepair = true;
                repairCost = Adrian.repairCost;
                System.out.println("Adrian naprawil");
            } else {
                successfulRepair = false;
                workerRepairChance(Janusz, car);
                repairCost = Adrian.repairCost + Janusz.repairCost;
                System.out.println("Adrian nie naprawil i Janusz robi za niego");
            }
        }
        return successfulRepair;
    }

    //Worker Repair
    public void workerRepair(Worker worker, Car car) {
        if (car.brokenPartsList.size() > 0) {
            if (worker == Janusz) {
                if (workerRepairChance(Janusz, car))
                    Repair(car);
            }
            if (worker == Marian) {
                if (workerRepairChance(Marian, car))
                    Repair(car);
            } else {
                if (workerRepairChance(Adrian, car))
                    Repair(car);
            }
        } else
            System.out.println("Powrót do garazu");
    }

    public void Repair(Car car) {
        for (int i = 0; i < car.brokenPartsList.size(); i++) {
            // TO DO LIST: chance to add, i jumps to 1, (Car car, double chance)
            switch (car.brokenPartsList.get(i)) {
                case BREAKS:
                    car.value = car.value * 1.1;
                    break;
                case SUSPENSION:
                    car.value = car.value * 1.2;
                    break;
                case ENGINE:
                    car.value = car.value * 2;
                    break;
                case BODY:
                case TRANSMISSION:
                    car.value = car.value * 1.5;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + car.brokenPartsList.get(i));
            }
        }
        car.brokenPartsList.clear();

    }
}
