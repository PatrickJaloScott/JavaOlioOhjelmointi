package com.metropolia.interfaces;

public class ElectricCar implements IElectricVehicle {
    private double storedElectricity = 0, maxElectricCharge;

    public ElectricCar(double maxElectricCharge) {
        this.maxElectricCharge = maxElectricCharge;
    }

    @Override
    public void charge() {
        storedElectricity = maxElectricCharge;
    }
}
