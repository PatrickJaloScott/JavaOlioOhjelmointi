package programs.calculators;

import model.Vector2;
import model.shapes.*;
import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("red", 5));
        shapes.add(new Rectangle("yellow", 4, 6));

        Vector2 A = new Vector2(2, 3),
                B = new Vector2(7,9),
                C = new Vector2(10, 1);
        Vector2 O = new Vector2(5,3),
                P = new Vector2(2, 7),
                Q = new Vector2(1, 3);
        Vector2 X = new Vector2(0, 0),
                Y = new Vector2(4.2132,3.5353),
                Z = new Vector2(6.1, 0);
        Triangle ABC = new Triangle("Red", A, B, C),
                OPQ = new Triangle("Green", O, P, Q),
                XYZ = new Triangle("Blue", X,Y,Z);

        shapes.add(ABC);
        shapes.add(OPQ);
        shapes.add(XYZ);
        ABC.printTriangle();

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
