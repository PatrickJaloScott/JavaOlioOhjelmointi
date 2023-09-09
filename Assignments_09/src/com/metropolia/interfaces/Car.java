package com.metropolia.interfaces;

public class Car extends AbstractVehicle implements IVehicle {
    private String color;

    public Car(String fuel, String color) {
        super("Car", fuel);
        this.color = color;
    }

    @Override
    public String getInfo() {
        System.out.println("Car Information:");
        return "Type: Car\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color + "\n";
    }
}
