package com.metropolia.interfaces;

public abstract class AbstractVehicle implements IVehicle {
    private String vehicleType, fuelType;

    public AbstractVehicle(String vehicleType, String fuelType) {
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

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public abstract String getInfo();
}
