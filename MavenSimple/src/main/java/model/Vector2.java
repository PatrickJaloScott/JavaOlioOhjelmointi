package model;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceTo(Vector2 v) {
        return Math.sqrt(Math.pow(v.x - this.x, 2) + Math.pow(v.y - this.y, 2));
    }

    @Override
    public String toString() {
        return '(' + x + ", " + y + ')';
    }
}
