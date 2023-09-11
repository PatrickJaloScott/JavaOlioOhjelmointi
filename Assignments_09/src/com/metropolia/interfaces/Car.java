package com.metropolia.interfaces;

public class Car extends AbstractVehicle implements IVehicle {
    private String color;
    private double fuelUse, miles;

    public Car(String fuel, String color, double fuelUse, double milage) {
        super("Car", fuel, fuelUse, milage);
        this.color = color;
        this.fuelUse = fuelUse;
        this.miles = milage;
    }

    @Override
    public String getInfo() {
        System.out.println("Car Information:");
        return "Type: Car\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color + "\n";
    }

    @Override
    public void calculateFuelEfficiency() {
        System.out.println("Fuel efficiency: " + miles + "/" + fuelUse + " miles/gallon\n");
    }
}
