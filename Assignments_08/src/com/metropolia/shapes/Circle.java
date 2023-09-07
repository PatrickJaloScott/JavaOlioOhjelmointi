package com.metropolia.shapes;

public class Circle extends Shape {
    private double radius = 0;

    public Circle(double radius) {
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
