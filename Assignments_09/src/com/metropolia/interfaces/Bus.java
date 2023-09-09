package com.metropolia.interfaces;

public class Bus extends AbstractVehicle implements IVehicle {
    private int passengerCapacity;

    public Bus(String fuel, int capacity) {
        super("Bus", fuel);
        this.passengerCapacity = capacity;
    }

    public String getInfo() {
        System.out.println("Bus Information:");
        return "Type: Bus\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Capacity: " + passengerCapacity + " passengers\n";
    }
}
