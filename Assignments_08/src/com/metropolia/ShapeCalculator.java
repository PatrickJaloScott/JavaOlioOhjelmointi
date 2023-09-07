package com.metropolia;

import com.metropolia.shapes.*;
import java.util.ArrayList;

public class ShapeCalculator {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(4, 6));
        shapes.add(new Triangle(3, 8));
        shapes.add(new Triangle(3,4));

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
            if(!shape1.getClass().equals(Triangle.class) && !shape2.getClass().equals(Triangle.class)) {
                System.out.println("Shapes are not compatible");
            }
            else {
                System.out.println("Shapes can be compatible");
            }
        }
    }
}
