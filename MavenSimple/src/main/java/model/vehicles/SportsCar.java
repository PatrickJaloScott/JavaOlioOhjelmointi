package model.vehicles;

public class SportsCar extends Car {
    public SportsCar(String typeName, int maxGas, int topSpeed) {
        super(typeName, maxGas, topSpeed);
    }

    @Override
    public void accelerate() {
        super.accelerate();
        super.accelerate();
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount*2);
    }
}
