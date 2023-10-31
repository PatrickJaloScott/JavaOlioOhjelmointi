package model.shapes;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super("rect", color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return "Area of Rectangle with width " + width + " and height " + height + ": " + calculateArea();
    }
}
