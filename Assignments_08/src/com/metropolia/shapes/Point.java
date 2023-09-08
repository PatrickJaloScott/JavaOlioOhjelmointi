package com.metropolia.shapes;

public class Point {
    private double x_coordinate, y_coordinate;
    public Point(double x, double y) {
        x_coordinate = x;
        y_coordinate = y;
    }

    double getX_coordinate() {
        return x_coordinate;
    }

    double getY_coordinate() {
        return y_coordinate;
    }

    public double distanceToPoint(Point p) {
        double a = p.getX_coordinate() - x_coordinate,
                b = p.getY_coordinate() - y_coordinate;
        return Math.sqrt(a*a + b*b);
    }

    @Override
    public String toString() {
        return "(" + x_coordinate + ", " + y_coordinate + ')';
    }
}
