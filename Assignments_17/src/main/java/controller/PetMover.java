package controller;

import javafx.application.Platform;
import model.Vector2;
import model.VirtualPet;
import view.PetView;

public class PetMover extends Thread {

    private final VirtualPet virtualPet;
    private final PetController petController;
    private PetView petView;
    private Vector2 petPosition;
    private Vector2 targetPosition;
    private final double baseStep = 1;
    private double step;
    private double distanceLimit = 0.9;

    public PetMover(VirtualPet pet, PetController controller, PetView view) {
        this.virtualPet = pet;
        this.petController = controller;
        this.petView = view;
        petPosition = pet.getPosition();
    }

    public void setPetPosition(Vector2 petPosition) {
        this.petPosition = petPosition;
        this.virtualPet.setPosition(petPosition);
    }

    public void setTarget(Vector2 target) {
        double targetOffsetX = Math.signum(target.getX() - petPosition.getX()) * 8;
        double targetOffsetY = Math.signum(target.getY() - petPosition.getY()) * 8;
        double targetX = target.getX() + targetOffsetX;
        double targetY = target.getY() + targetOffsetY;
        targetPosition = new Vector2(targetX, targetY);
    }

    @Override
    public synchronized void start() {
        step = baseStep;
        double distance = petPosition.distanceTo(targetPosition);
        System.out.println("Entering while-loop. Distance to target: " + distance);
        int loops = 0;
        double distanceCheck;
        while (distance > 0) {
            distanceCheck = distance;
            loops++;
            System.out.printf("While loop: %d; Moved ", loops);
            if (petPosition.getX() < targetPosition.getX()) {
                petPosition.setX(petPosition.getX() + step);
                System.out.print("right\t");
            }
            if (petPosition.getX() > targetPosition.getX()) {
                petPosition.setX(petPosition.getX() - step);
                System.out.print("left\t");
            }
            if (petPosition.getY() < targetPosition.getY()) {
                petPosition.setY(petPosition.getY() + step);
                System.out.print("down\t");
            }
            if (petPosition.getY() > targetPosition.getY()) {
                petPosition.setY(petPosition.getY() - step);
                System.out.print("up\t");
            }
            distance = petPosition.distanceTo(targetPosition);
            System.out.println("Distance " + distance);
            if(distance == distanceCheck) {
                step *= 0.9;
            }
            if(distance < distanceLimit) {
                petPosition.setX(targetPosition.getX());
                petPosition.setY(targetPosition.getY());
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException interruption) {
                System.err.println("Caught interruption " + interruption.getMessage());
            }
            Platform.runLater(() -> {
                virtualPet.setPosition(petPosition);
                petView.updateCanvas(petPosition.getX(), petPosition.getY());
            });
        }
    }
}