package model.vehicles;

import interfaces.vehicles.IElectricVehicle;

public class ElectricCar implements IElectricVehicle {
    private double storedElectricity = 0;
    private final double maxElectricCharge;

    public ElectricCar(double maxElectricCharge) {
        this.maxElectricCharge = maxElectricCharge;
    }

    @Override
    public void charge() {
        storedElectricity = maxElectricCharge;
    }
}
