package model.vehicles;

import interfaces.vehicles.IVehicle;

public abstract class AbstractVehicle implements IVehicle {
    private final String vehicleType;
    private String fuelType;

    public AbstractVehicle(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public AbstractVehicle(String vehicleType, String fuelType, double fuelUse, double milage) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        System.out.println(vehicleType + " starting engine");
    }

    @Override
    public void stop() {
        System.out.println(vehicleType + " shutting engine off");
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public abstract String getInfo();
}
