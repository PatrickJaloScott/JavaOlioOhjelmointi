package application.view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private DictionaryController controller;
    private TextField wordEntryField;
    private TextField wordSearchField;
    private TextArea definitionEntryField;
    private Label searchResultLabel;
    Label entryErrorLabel = new Label();
    private Color errorColor;
    private Color warningColor;

    @Override
    public void start(Stage stage) {
        errorColor = Color.RED;
        warningColor = Color.BLUE;
        Insets leftPadding = new Insets(0,0,0,10);

        Label entryLabel = new Label("Add a new word");
        wordEntryField = new TextField("Word");
        GridPane.setValignment(wordEntryField, VPos.TOP);
        GridPane.setMargin(wordEntryField, leftPadding);
        definitionEntryField = new TextArea("");
        definitionEntryField.setWrapText(true);
        definitionEntryField.setMaxWidth(200);
        definitionEntryField.setMaxHeight(100);
        Button addEntryButton = new Button("Add Word");
        Label searchLabel = new Label("Word search");
        GridPane.setMargin(searchLabel, leftPadding);
        wordSearchField = new TextField("Search for...");
        GridPane.setMargin(wordSearchField, leftPadding);
        Button searchButton = new Button("Search");
        searchResultLabel = new Label();
        searchResultLabel.setWrapText(true);
        searchResultLabel.setMaxWidth(200);

        GridPane gridPane = new GridPane();
        // set up word entry layout
        GridPane.setConstraints(entryLabel,0,0);
        GridPane.setMargin(entryLabel, new Insets(10,0,0,10));
        GridPane.setConstraints(wordEntryField, 0,1);
        GridPane.setConstraints(definitionEntryField,1,1);
        GridPane.setConstraints(addEntryButton, 2, 1);
        GridPane.setConstraints(entryErrorLabel, 1, 2);

        // set up word search layout
        GridPane.setConstraints(searchLabel, 0, 3);
        GridPane.setConstraints(wordSearchField, 0, 4);
        GridPane.setConstraints(searchButton, 1, 4);
        GridPane.setConstraints(searchResultLabel, 1, 5);

        gridPane.getChildren().addAll(entryLabel, wordEntryField, definitionEntryField, addEntryButton, entryErrorLabel);
        gridPane.getChildren().addAll(searchLabel, wordSearchField, searchButton, searchResultLabel);

        // ActionEvent settings
        addEntryButton.setOnAction(actionEvent -> controller.addEntry(wordEntryField.getText(), definitionEntryField.getText()));
        searchButton.setOnAction(actionEvent -> controller.setDefinitionSearchGUI(wordSearchField.getText()));
        wordSearchField.setOnAction(actionEvent -> controller.setDefinitionSearchGUI(wordSearchField.getText()));

        stage.setTitle("Virtual Dictionary");
        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        controller = new DictionaryController(this);
    }

    public void clearEntryFields() {
        wordEntryField.setText("");
        definitionEntryField.setText("");
    }

    public void setEntryError() {
        entryErrorLabel.setText("Please enter a word and definition");
        entryErrorLabel.setTextFill(errorColor);
    }

    public void setDefinitionText(String word, String definition) {
        searchResultLabel.setText(word + " - " + definition);
        searchResultLabel.setTextFill(Color.BLACK);
    }

    public void setDefinitionError(String word) {
        searchResultLabel.setText("Could not find " + word);
        searchResultLabel.setTextFill(errorColor);
    }

    public void setDefinitionWarning() {
        searchResultLabel.setText("Could not search empty query");
        searchResultLabel.setTextFill(warningColor);
    }
}
