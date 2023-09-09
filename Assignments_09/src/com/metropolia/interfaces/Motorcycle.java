package com.metropolia.interfaces;

public class Motorcycle implements IVehicle {
    private String fuel, color;

    public Motorcycle(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle starting up");
    }

    @Override
    public void stop() {
        System.out.println("Engine off");
    }

    @Override
    public String getInfo() {

        System.out.println("Motorcycle Information:");
        return "Type: Motorcycle\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n";
    }
}
