package com.metropolia.association;

public class Car {
    private float speed, maxSpeed;
    private float gasolineLevel, gasolineCapacity;
    private final String typeName;

    // Cruise control
    private boolean cruiseControlOn;
    private float targetSpeed;
    private float minTargetSpeed, maxTargetSpeed;

    public Car(String typeName) {
        this.speed = 0;
        gasolineLevel = 0;

        this.typeName = typeName;
    }

    public Car(String typeName, int maxGas, int topSpeed) {
        this(typeName);
        this.gasolineCapacity = maxGas;
        this.maxSpeed = topSpeed;
    }

    public Car(String typeName, int maxGas, int topSpeed, float minCruiseSpeed, float maxCruiseSpeed) {
        this(typeName, maxGas, topSpeed);
        this.minTargetSpeed = minCruiseSpeed;
        this.maxTargetSpeed = maxCruiseSpeed;
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

    public void setCruiseSpeed(float target) {
        if(target >= minTargetSpeed && target <= maxTargetSpeed) {
            this.targetSpeed = target;
        } else {
            setCruiseControlOn();
        }
        while (this.cruiseControlOn && this.speed != this.targetSpeed) {
            if(this.speed < this.targetSpeed) {
                accelerate();
            } else if(this.speed > this.targetSpeed) {
                decelerate(10);
            }
            System.out.println(typeName + ": speed is " + speed + " km/h");
        }
    }

    public float getTargetSpeed() {
        return targetSpeed;
    }

    public void setCruiseControlOn() {
        this.cruiseControlOn = !this.cruiseControlOn;
        String mode = this.cruiseControlOn ? "on" : "off";
        System.out.println("Cruise control is " + mode);
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = gasolineCapacity;
    }

    public float getGasolineLevel() {
        return gasolineLevel;
    }

}
