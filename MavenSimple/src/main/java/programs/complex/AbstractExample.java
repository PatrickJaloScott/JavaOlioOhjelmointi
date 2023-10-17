package programs.complex;

import model.testing.shapes.Circle;

public class AbstractExample {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 3.0);
        circle.displayColor();
        System.out.println("Circle Area " + circle.calculateArea());
    }
}
