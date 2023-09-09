package com.metropolia.interfaces;

public class Motorcycle extends AbstractVehicle implements IVehicle {
    private String color;

    public Motorcycle(String fuel, String color) {
        super("Motorcycle", fuel);
        this.color = color;
    }

    @Override
    public String getInfo() {

        System.out.println("Motorcycle Information:");
        return "Type: Motorcycle\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color + "\n";
    }
}
