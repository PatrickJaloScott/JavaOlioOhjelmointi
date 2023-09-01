package com.metropolia.car;

public class ModifiedCar {
    private float speed, maxSpeed;
    private float gasolineLevel, gasolineCapacity;
    private String typeName;

    public ModifiedCar(String typeName) {
        this.speed = 0;
        gasolineLevel = 0;

        this.typeName = typeName;
    }

    public ModifiedCar(String typeName, int maxGas, int topSpeed) {
        this(typeName);
        this.maxSpeed = topSpeed;
        this.gasolineCapacity = maxGas;
    }

    public void accelerate() {
        if(gasolineLevel > 0) {
            speed += 10;
        }
        else {
            speed = 0;
        }
    }

    void decelerate(int amount) {
        if(gasolineLevel > 0) {
            if(amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        }
        else {
            speed = 0;
        }
    }

    public float getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    public float getGasolineLevel() {
        return gasolineLevel;
    }
}
