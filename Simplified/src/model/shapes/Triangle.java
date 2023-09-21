package model.shapes;

public class Triangle extends Shape {
    private final Point p_A, p_B, p_C;
    private final double side_a, side_b, side_c;
    private double alpha, beta, gamma;
    public Triangle(Point a, Point b, Point c) {
        p_A = a; p_B = b; p_C = c;

        side_a = p_B.distanceToPoint(p_C);
        side_b = p_C.distanceToPoint(p_A);
        side_c = p_A.distanceToPoint(p_B);
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
}
