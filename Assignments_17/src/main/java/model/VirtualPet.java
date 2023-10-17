package model;

public class VirtualPet {
    private Vector2 position;
    private static final int GRID_SIZE = 20;

    public VirtualPet(double x, double y) {
        position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 pos) {
        this.position.setX(pos.getX());
        this.position.setY(pos.getY());
    }

    public void setPosition(double x, double y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }
}
