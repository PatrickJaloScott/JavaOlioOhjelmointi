package program.calculator;

import model.shapes.*;
import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(4, 6));

        Point A = new Point(2, 3),
                B = new Point(7,9),
                C = new Point(10, 1);
        Point O = new Point(5,3),
                P = new Point(2, 7),
                Q = new Point(1, 3);
        Point X = new Point(0, 0),
                Y = new Point(4.2132,3.5353),
                Z = new Point(6.1, 0);
        Triangle ABC = new Triangle(A, B, C),
                OPQ = new Triangle(O, P, Q),
                XYZ = new Triangle(X,Y,Z);

        shapes.add(ABC);
        shapes.add(OPQ);
        shapes.add(XYZ);

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        checkCompatibility(shapes.get(0), shapes.get(1));
        checkCompatibility(shapes.get(0), shapes.get(2));
        checkCompatibility(shapes.get(1), shapes.get(2));
        checkCompatibility(shapes.get(2), shapes.get(3));
    }

    static void checkCompatibility(Shape shape1, Shape shape2) {
        if(shape1.getClass().equals(shape2.getClass())) {
            System.out.println("Shapes are compatible");
        }
        else {
            if (shape1.getClass().equals(Triangle.class) || shape2.getClass().equals(Triangle.class)) {
                System.out.println("Shapes can be compatible");
            } else {
                System.out.println("Shapes are not compatible");
            }
        }
    }
}
