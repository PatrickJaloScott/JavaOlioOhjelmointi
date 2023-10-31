package model.shapes;

public abstract class Shape {
    protected String color;
    private String type;

    public Shape(String shapeType, String color) {
        this.type = shapeType;
        this.color = color;
    }

    public abstract double calculateArea();

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
