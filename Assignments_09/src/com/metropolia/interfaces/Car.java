package com.metropolia.interfaces;

public class Car implements IVehicle {
    private String fuel, color;

    public Car(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car starting up...");
    }

    @Override
    public void stop() {
        System.out.println("Engine off...");
    }

    @Override
    public String getInfo() {
        System.out.println("Car Information:");
        return "Type: Car\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n";
    }
}
