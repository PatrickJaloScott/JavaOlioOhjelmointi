package application.view;

import application.controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PetView extends Application {
    private static final int CELL_SIZE = 20;
    private double canvasSize;
    double scaledDimension;
    private PetController controller;
    private ImageView petImgView;

    @Override
    public void start(Stage stage) {
        double imageDimensions = 16;
        Image petImage = new Image("/pet-icon.png", imageDimensions, imageDimensions, false, false);
        petImgView = new ImageView(petImage);

        controller = new PetController(this);
        canvasSize = controller.getGridSize() * CELL_SIZE;
        scaledDimension = canvasSize / 2.0;
        controller.setStartPosition(
                scaledDimension - (imageDimensions/2),
                scaledDimension - (imageDimensions / 2));
        petImgView.setX(scaledDimension - (imageDimensions / 2));
        petImgView.setY(scaledDimension - (imageDimensions / 2));
        Canvas canvas = new Canvas(canvasSize, canvasSize);
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);
        Rectangle rect = new Rectangle(0, 0, canvasSize, canvasSize);
        rect.setFill(new Color(0, 1, 1, 0.5));

        canvas.setOnMouseMoved(mouseMove -> {
            // target coordinates = mouse.x, mouse.y
            double x = mouseMove.getX();
            double y = mouseMove.getY();

            if(isMouseWithinBounds(x, y)) {
                controller.handleMove(x, y);
            }
        });
        canvas.setOnMouseExited(mouseExit -> controller.stopMovement());

        Pane root = new Pane(rect, canvas, petImgView);
        Scene scene = new Scene(root, canvasSize, canvasSize);
        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();

        // updateCanvas();
    }

    private boolean isMouseWithinBounds(double mouseX, double mouseY) {
        boolean xInBounds = mouseX > CELL_SIZE && mouseX < canvasSize - CELL_SIZE;
        boolean yInBounds = mouseY > CELL_SIZE && mouseY < canvasSize - CELL_SIZE;
        return xInBounds && yInBounds;
    }

    public synchronized void updateCanvas(double petPosX, double petPosY) {
        petImgView.setX(petPosX);
        petImgView.setY(petPosY);
    }
}
