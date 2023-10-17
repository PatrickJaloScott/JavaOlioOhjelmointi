package controller;

import model.Vector2;
import model.VirtualPet;
import view.PetView;

public class PetController {
    private final VirtualPet pet;
    PetMover petMover;
    PetView view;

    public PetController(PetView view) {
        this.pet = new VirtualPet(0, 0);
        this.view = view;
        this.petMover = new PetMover(this.pet, this, view);
    }

    public void handleMove(double dirX, double dirY) {
        Vector2 destination = new Vector2(dirX, dirY);
        petMover.setTarget(destination);
        petMover.start();
    }

    public void stopMovement() {
        petMover.interrupt();
    }

    public void setStartPosition(double x, double y) {
        this.petMover.setPetPosition(new Vector2(x, y));
    }

    public Vector2 getPetPosition() {
        return pet.getPosition();
    }

    public int getGridSize() {
        return VirtualPet.getGridSize();
    }

    /*public void updateCanvas(Vector2 newPosition) {
        view.updateCanvas(newPosition.getX(), newPosition.getY());
    }*/
}
