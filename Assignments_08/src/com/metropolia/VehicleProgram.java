package com.metropolia;

import com.metropolia.inheritance.Bus;
import com.metropolia.inheritance.SportsCar;

public class VehicleProgram {

    public static void main(String[] args) {
        SportsCar porsche = new SportsCar("Porsche 911", 3000, 180);
        Bus schoolBus = new Bus("Yellow School Bus", 30, 2800, 48);

        porsche.fillTank();
        schoolBus.fillTank();

        for (int i = 0; i < 6; i++) {
            porsche.accelerate();
            schoolBus.accelerate();
            System.out.println(porsche.getTypeName() + ": accelerating " + porsche.getSpeed() + " mph");
            System.out.println(schoolBus.getTypeName() + ": accelerating " + schoolBus.getSpeed() + " km/h");
        }

        while (porsche.getSpeed() > 0) {
            porsche.decelerate(10);
            System.out.println(porsche.getTypeName() + ": decelerating " + porsche.getSpeed());
        }

        while (schoolBus.getSpeed() > 0) {
            schoolBus.decelerate(10);
            System.out.println(schoolBus.getTypeName() + ": decelerating " + schoolBus.getSpeed());
        }
    }
}
