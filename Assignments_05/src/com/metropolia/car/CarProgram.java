package com.metropolia.car;

public class CarProgram {
    public static void main(String[] args) {
        ModifiedCar myCar = new ModifiedCar("Toyota Corolla", 100, 200, 40, 80);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setCruiseControlOn();
        myCar.setCruiseSpeed(70);
        myCar.setCruiseControlOn();
    }
}
