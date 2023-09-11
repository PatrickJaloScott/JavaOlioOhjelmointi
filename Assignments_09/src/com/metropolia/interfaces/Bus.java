package com.metropolia.interfaces;

public class Bus extends AbstractVehicle implements IVehicle {
    private int passengerCapacity;
    private double miles, fuelConsumption;

    public Bus(String fuel, int capacity, double fuelUse, double milage) {
        super("Bus", fuel, fuelUse, milage);
        this.miles = milage;
        this.fuelConsumption = fuelUse;
        this.passengerCapacity = capacity;
    }

    public String getInfo() {
        System.out.println("Bus Information:");
        return "Type: Bus\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Capacity: " + passengerCapacity + " passengers\n";
    }

    @Override
    public void calculateFuelEfficiency() {
        System.out.println("Fuel efficiency: " + miles + "/" + fuelConsumption + " miles/gallon\n");
    }
}
