package model.shapes;

import model.Vector2;

public class Triangle extends Shape {
    private final Vector2 p_A, p_B, p_C;
    private final double side_a, side_b, side_c;
    private double alpha, beta, gamma;
    public Triangle(String color, Vector2 a, Vector2 b, Vector2 c) {
        super("triangle", color);
        p_A = a; p_B = b; p_C = c;

        side_a = p_B.distanceTo(p_C);
        side_b = p_C.distanceTo(p_A);
        side_c = p_A.distanceTo(p_B);
    }

    @Override
    public double calculateArea() {
        alpha = Math.acos((side_a*side_a - side_b*side_b - side_c*side_c)/(-2*side_b*side_c));
        beta = Math.asin(side_c*Math.sin(alpha)/side_a);
        gamma = Math.PI - alpha - beta;

        return side_a * side_c * Math.sin(beta)/2;
    }

    @Override
    public String toString() {
        return String.format("Area of Triangle with points %s, %s, %s : %.3f", p_A, p_B, p_C, calculateArea());
    }

    public void printTriangle() {
        double startY = p_A.getY();
        double endY = p_A.getY();
        double startX = p_A.getX();
        double endX = p_A.getX();

        startY = Math.max(startY, p_B.getY());
        startY = Math.max(startY, p_C.getY());

        startX = Math.min(startX, p_B.getX());
        startX = Math.min(startX, p_C.getX());

        endY = Math.min(endY, p_B.getY());
        endY = Math.min(endY, p_C.getY());

        endX = Math.max(endX, p_B.getX());
        endX = Math.max(endX, p_C.getX());

        for(double j = startY; j >= endY; j--) {
            for (double i = startX; i <= endX; i++) {
                Vector2 currenetPoint = new Vector2(i, j);
                if(currenetPoint.distanceTo(p_A) == 0 || currenetPoint.distanceTo(p_B) == 0 || currenetPoint.distanceTo(p_C) == 0) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
