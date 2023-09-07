package com.metropolia.shapes;

public class Triangle extends Shape {
    private double sideA, sideB;
    public Triangle(int base, int height) {
        sideA = base;
        sideB = height;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB/2;
    }

    @Override
    public String toString() {
        return "Area of Triangle with base " + sideA + " and height " + sideB + ": " + calculateArea();
    }
}
