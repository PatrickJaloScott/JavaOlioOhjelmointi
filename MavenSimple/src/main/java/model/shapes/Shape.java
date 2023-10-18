package model.shapes;

public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public void setColor(String color) {
        this.color = color;
    }

    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
