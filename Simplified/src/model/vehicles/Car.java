package model.vehicles;

import interfaces.IVehicle;

public class Car extends AbstractVehicle implements IVehicle {
    private float speed, maxSpeed;
    private float gasolineLevel, gasolineCapacity;
    private double fuelUse, miles;
    private String carModel;
    private String color;

    public Car(String fuelType, String color, double fuelUse, double milage) {
        super("Car", fuelType, fuelUse, milage);
        this.speed = 0;
        gasolineLevel = 0;

        this.color = color;
        this.fuelUse = fuelUse;
        this.miles = milage;
    }

    public Car(String model, int maxGas, int topSpeed) {
        this("gasoline", "white", 0, 0);
        this.carModel = model;
        this.gasolineCapacity = maxGas;
        this.maxSpeed = topSpeed;
    }

    public void accelerate() {
        if(gasolineLevel > 0) {
            speed += 10;
            if(speed > maxSpeed) {
                speed = maxSpeed;
            }
            gasolineLevel -= 5;
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if(gasolineLevel > 0) {
            if(amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public void fillTank() {
        gasolineLevel = gasolineCapacity;
    }

    public float getGasolineLevel() {
        return gasolineLevel;
    }

    public String getCarModel() {
        return carModel;
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
