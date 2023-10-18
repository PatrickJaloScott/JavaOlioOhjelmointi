package model.vehicles;

import interfaces.vehicles.IVehicle;

public class Motorcycle extends AbstractVehicle implements IVehicle {
    private final String color;
    private double miles, fuelConsumption;

    public Motorcycle(String fuel, String color, double milage, double fuelUse) {
        super("Motorcycle", fuel, fuelUse, milage);
        this.miles = milage;
        this.fuelConsumption = fuelUse;
        this.color = color;
    }

    @Override
    public String getInfo() {

        System.out.println("Motorcycle Information:");
        return "Type: Motorcycle\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color + "\n";
    }

    @Override
    public void calculateFuelEfficiency() {
        System.out.println("Fuel efficiency: " + miles + "/" + fuelConsumption + " miles/gallon\n");
    }
}
