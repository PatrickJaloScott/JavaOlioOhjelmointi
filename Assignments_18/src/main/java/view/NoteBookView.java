package view;

import controller.NoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NoteBookView extends Application {

    NoteController controller;

    @Override
    public void start(Stage window) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook_app_view.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            System.err.println("Encountered error loading fxml. " + e.getCause());
        }

        window.setScene(new Scene(root));
        window.setTitle("Notebook");
        window.show();
    }
    @Override
    public void init() throws Exception {
        controller = new NoteController();
    }
}
