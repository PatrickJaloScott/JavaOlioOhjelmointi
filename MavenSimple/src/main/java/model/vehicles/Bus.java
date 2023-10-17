package model.vehicles;

import interfaces.IVehicle;

public class Bus extends Car implements IVehicle {

    private int passengers = 0, passengerCapacity;
    double maxGas, topSpeed;

    public Bus(String fuelType, int passengerCapacity, double maxGas, double topSpeed) {
        super("Bus", fuelType, 0, 0);
        this.passengerCapacity = passengerCapacity;
        this.maxGas = maxGas;
        this.topSpeed = topSpeed;
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

    @Override
    public String getInfo() {
        return "Bus\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Passengers: " + passengers + "/" + passengerCapacity + "\n" +
                "Max gas: " + maxGas + "\n" +
                "Top speed: " + topSpeed + "\n";
    }

    @Override
    public void calculateFuelEfficiency() {
        System.out.println("Fuel efficiency: " + maxGas + "/" + topSpeed + " miles/gallon\n");
    }
}
