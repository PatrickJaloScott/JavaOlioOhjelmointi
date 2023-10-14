package application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CurrencyGUI extends Application {
    @Override
    public void start(Stage window) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Currency Converter.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            System.err.println("Encountered error loading fxml. " + e.getCause());
        }
        FXMLController controller = fxmlLoader.getController();
        controller.initiate();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
