package com.metropolia.inheritance;

import com.metropolia.association.Car;

public class Bus extends Car {

    private int passengers = 0, passengerCapacity;

    public Bus(String typeName, int passengerCapacity, int maxGas, int topSpeed) {
        super(typeName, maxGas, topSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    public void passengerEnter(int amount) {
        if(passengers + amount <= passengerCapacity) {
            passengers += amount;
        }
        else {
            passengers = passengerCapacity;
        }
    }

    public void passengerExit(int amount) {
        passengers = Math.max(0, passengers - amount);
    }
}
