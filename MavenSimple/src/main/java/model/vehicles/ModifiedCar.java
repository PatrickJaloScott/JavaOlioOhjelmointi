package model.vehicles;

public class ModifiedCar extends Car {
    // Cruise control
    private boolean cruiseControlOn;
    private float targetSpeed;
    private float minTargetSpeed, maxTargetSpeed;

    public ModifiedCar(String model, int maxGas, int topSpeed, float minCruiseSpeed, float maxCruiseSpeed) {
        super(model, maxGas, topSpeed);
        this.minTargetSpeed = minCruiseSpeed;
        this.maxTargetSpeed = maxCruiseSpeed;
    }

    public void accelerate() {
        super.accelerate();
    }

    public void decelerate(int amount) {
        super.decelerate(amount);
    }

    public void setCruiseSpeed(float target) {
        if(target >= minTargetSpeed && target <= maxTargetSpeed) {
            this.targetSpeed = target;
        } else {
            setCruiseControlOn();
        }
        while (this.cruiseControlOn && getSpeed() != this.targetSpeed) {
            if(getSpeed() < this.targetSpeed) {
                accelerate();
            } else if(getSpeed() > this.targetSpeed) {
                decelerate(10);
            }
            System.out.println(getVehicleType() + ": speed is " + getSpeed() + " km/h");
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

    public void fillTank() {
        super.fillTank();
    }
}
