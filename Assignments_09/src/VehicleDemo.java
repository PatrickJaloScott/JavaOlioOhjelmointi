import com.metropolia.interfaces.*;

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Petrol", "Red", 1000, 200000);
        Motorcycle motorcycle = new Motorcycle("Gasoline", "Black", 150000, 500);
        Bus bus = new Bus("Diesel", 40, 3000, 1000000);

        car.start();
        car.stop();
        System.out.print(car.getInfo());
        car.calculateFuelEfficiency();

        motorcycle.start();
        motorcycle.stop();
        System.out.print(motorcycle.getInfo());
        motorcycle.calculateFuelEfficiency();

        bus.start();
        bus.stop();
        System.out.print(bus.getInfo());
        bus.calculateFuelEfficiency();

        System.out.println("Electric vehicles");
        ElectricCar sahkoAuto = new ElectricCar(500);
        sahkoAuto.charge();

        ElectricMotorcycle mopo = new ElectricMotorcycle(75);
        mopo.charge();
    }
}
