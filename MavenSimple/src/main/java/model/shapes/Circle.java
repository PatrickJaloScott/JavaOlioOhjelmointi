package model.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super("circle", color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Area of Circle with radius " + radius + ": " + calculateArea();
    }
}
