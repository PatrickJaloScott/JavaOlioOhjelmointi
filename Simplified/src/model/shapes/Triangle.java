package model.shapes;

public class Triangle extends Shape {
    private final Point p_A, p_B, p_C;
    private final double side_a, side_b, side_c;
    private double alpha, beta, gamma;
    public Triangle(String color, Point a, Point b, Point c) {
        super(color);
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

    public void printTriangle() {
        double startY = p_A.getY_coordinate();
        double endY = p_A.getY_coordinate();
        double startX = p_A.getX_coordinate();
        double endX = p_A.getX_coordinate();

        startY = Math.max(startY, p_B.getY_coordinate());
        startY = Math.max(startY, p_C.getY_coordinate());

        startX = Math.min(startX, p_B.getX_coordinate());
        startX = Math.min(startX, p_C.getX_coordinate());

        endY = Math.min(endY, p_B.getY_coordinate());
        endY = Math.min(endY, p_C.getY_coordinate());

        endX = Math.max(endX, p_B.getX_coordinate());
        endX = Math.max(endX, p_C.getX_coordinate());

        for(double j = startY; j >= endY; j--) {
            for (double i = startX; i <= endX; i++) {
                Point currenetPoint = new Point(i, j);
                if(currenetPoint.distanceToPoint(p_A) == 0 || currenetPoint.distanceToPoint(p_B) == 0 || currenetPoint.distanceToPoint(p_C) == 0) {
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
