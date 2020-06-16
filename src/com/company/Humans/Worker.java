package com.company.Humans;

import com.company.RandomNumberGenerator;
import com.company.Vehicles.Car;


public class Worker extends Human {
    public double repairChance;
    public double repairCost;
    private double damagingPartChance;
    boolean successfulRepair;

    public Worker(String firstName, String lastName, double cash,double repairCost,double damagingPartChance) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.repairCost = repairCost;
        this.damagingPartChance = damagingPartChance;
    }
    Worker Janusz = new Worker("Janusz","Kowalski",5000,1,0);
    Worker Marian = new Worker("Marian","Wilk",4500,0.9,0);
    Worker Adrian = new Worker("Adrian","Nowak",3000,0.8,0.02);

    public void workerRepairChance(Worker worker){
        int chance = RandomNumberGenerator.getRandomValue(0,100);
        if (worker == Janusz){
            successfulRepair = true;
            repairCost = Janusz.repairCost;
        }
        if (worker == Marian){
          if(chance <= 90){
            successfulRepair = true;
            repairCost = Marian.repairCost;
          }else{
              successfulRepair = false;
              workerRepairChance(Janusz);
              repairCost = Janusz.repairCost + Marian.repairCost;
          }
        }
        if (worker == Adrian){
            if(chance <= 80){
                successfulRepair = true;
                repairCost = Adrian.repairCost;
            }if(chance >= 81){
                successfulRepair = false;
                workerRepairChance(Janusz);
                repairCost = Janusz.repairCost + Adrian.repairCost;
            }
        }

    }
    //Worker Repair
    public void workerRepair(Worker worker){
        if (worker == Janusz){
            workerRepairChance(Janusz);
        } if (worker == Marian){
            workerRepairChance(Marian);
        } else {
            workerRepairChance(Adrian);
        }
    }

    public void Repair(Car car){
        for (int i = 0; i < car.brokenPartsList.size(); i++){
            // TO DO LIST: chance to add, i jumps to 1, (Car car, double chance)
            switch (car.brokenPartsList.get(i)){
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
