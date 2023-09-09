package com.metropolia.interfaces;

public class Bus implements IVehicle {
    private String fuel;
    private int passengerCapacity;

    public Bus(String fuel, int capacity) {
        this.fuel = fuel;
        this.passengerCapacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus starting up");
    }

    @Override
    public void stop() {
        System.out.println("Engine off");
    }

    @Override
    public String getInfo() {
        System.out.println("Bus Information:");
        return "Type: Bus\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + passengerCapacity + "\n";
    }
}
