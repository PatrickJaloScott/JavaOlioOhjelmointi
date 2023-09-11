package com.metropolia.interfaces;

public class ElectricMotorcycle implements IElectricVehicle {
    private double storedElectricity = 0, maxElectricity;

    public ElectricMotorcycle(double maxElectricity) {
        this.maxElectricity = maxElectricity;
    }

    @Override
    public void charge() {
        storedElectricity = maxElectricity;
    }
}
