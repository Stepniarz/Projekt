package com.company.Humans;

import com.company.Enums.brokenPart;
import com.company.Places.Garage;
import com.company.RandomNumberGenerator;
import com.company.Vehicles.Car;


public class Worker extends Human {
    public double repairChance;
    public double repairCost;
    public Garage garage;

    public Worker(String firstName, double cash, double repairCost,int repairChance) {
        super(cash);
        this.firstName = firstName;
        this.repairCost = repairCost;
        this.repairChance = repairChance;
    }


    public static Worker Janusz = new Worker("Janusz",  5000, 1000, 100);
    public static Worker Marian = new Worker("Marian",  4500, 750,90);
    public static Worker Adrian = new Worker("Adrian",  3000, 300,80);
//worker's chance for repair + picking Janusz for repair if failed
    public static boolean workerRepairChance(Worker worker, Car car,Player player) {
        boolean successfulRepair = false;
        int chance = RandomNumberGenerator.getRandomValue(0, 100);
        double fullRepairCost = 0;
        System.out.println(chance);
        if (worker == Janusz) {
            successfulRepair = true;
            for (brokenPart brokenPart : car.brokenPartsList){
                fullRepairCost += Janusz.repairCost;
            }

            System.out.println("Janusz naprawia");
        }
        if (worker == Marian) {
            if (chance <= Marian.repairChance) {
                successfulRepair = true;
                for (brokenPart brokenPart : car.brokenPartsList){
                    fullRepairCost += Marian.repairCost;
                }
            } else {
                successfulRepair = false;
                workerRepairChance(Janusz, car,player);
                for (brokenPart brokenPart : car.brokenPartsList){
                    fullRepairCost += Marian.repairCost;
                }
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
                } else
                    System.out.println("Nie da sie bardziej popsuc auta");
            }
            if (chance <= Adrian.repairChance) {
                successfulRepair = true;
                for (brokenPart brokenPart : car.brokenPartsList){
                    fullRepairCost += Adrian.repairCost;
                }
                System.out.println("Adrian naprawil");
            } else {
                successfulRepair = false;
                workerRepairChance(Janusz, car,player);
                for (brokenPart brokenPart : car.brokenPartsList){
                    fullRepairCost += Adrian.repairCost;
                }
                System.out.println("Adrian nie naprawil i Janusz robi za niego");
            }
        }
        player.cash -= fullRepairCost;
        return successfulRepair;
    }

    //Worker Repair
    public static void workerRepair(int worker, Car car,Player player) {
        if (car.brokenPartsList.size() > 0) {
            if (worker == 1) {
                if (workerRepairChance(Janusz, car,player))
                    Repair(car);
                player.garage.carsAvailableForSale.add(car);
            }
            if (worker == 2) {
                if (workerRepairChance(Marian, car,player))
                    Repair(car);
                player.garage.carsAvailableForSale.add(car);
            } if (worker == 3) {
                if (workerRepairChance(Adrian, car,player))
                    Repair(car);
                player.garage.carsAvailableForSale.add(car);
            }
        } else
            System.out.println("Powrót do garazu");
    }
    //Repair of broken parts increasing car's value for each repaired part
    public static void Repair(Car car) {
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
    public static void showWorkers(){
        System.out.println("1. " + Worker.Janusz);
        System.out.println("2. " + Worker.Marian);
        System.out.println("3. " + Worker.Adrian);
    }


    @Override
    public String toString() {
        return "Worker{" +
                "firstName: " + firstName +
                ", repairChance: " + repairChance +
                ", repairCost: " + repairCost +
                '}';
    }
}
