package model.vehicles;

import interfaces.vehicles.IElectricVehicle;

public class ElectricMotorcycle implements IElectricVehicle {
    private double storedElectricity = 0;
    private final double maxElectricity;

    public ElectricMotorcycle(double maxElectricity) {
        this.maxElectricity = maxElectricity;
    }

    @Override
    public void charge() {
        storedElectricity = maxElectricity;
    }
}
