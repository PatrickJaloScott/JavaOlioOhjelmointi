package interfaces.vehicles;

public interface IVehicle {
    void start();
    void stop();
    abstract String getInfo();
    void calculateFuelEfficiency();
}
