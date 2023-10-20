package application.view;

import application.controller.CurrencyController;
import application.controller.NoteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

public class FXMLController {
    // Currency Converter GUI
    private final CurrencyController currencyController;
    @FXML
    private ChoiceBox<String> fromChoiceBox;
    @FXML
    private ComboBox<String> toComboBox;
    @FXML
    private TextField inputTextField;
    @FXML
    private Label outputLabel;

    // NoteBook GUI
    @FXML
    private ListView<String> noteListView;
    private final NoteController noteController;
    private ObservableList<String> noteTitles, noteListContent;
    @FXML
    private TextField noteTitleField;
    @FXML
    private TextArea noteContentArea;
    @FXML
    private Button addNoteButton;

    public FXMLController() {
        currencyController = new CurrencyController();
        noteController = new NoteController();
    }

    public void initiate() {
        // Currency Converter setup
        String[] currencyAbbreviations = currencyController.getCurrencies();
        inputTextField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        fromChoiceBox.getItems().addAll(currencyAbbreviations);
        fromChoiceBox.setValue(fromChoiceBox.getItems().get(0));
        toComboBox.getItems().addAll(currencyAbbreviations);
        toComboBox.setValue(toComboBox.getItems().get(1));

        // NoteBook setup
        noteListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        noteTitles = FXCollections.observableArrayList(noteController.getNoteTitles());
        noteListContent = FXCollections.observableArrayList();
        noteListView.setItems(noteTitles);
    }

    private double getInputCurrencyRate() {
        return currencyController.getCurrencyRate(fromChoiceBox.getValue());
    }

    private double getOutputCurrencyRate() {
        return currencyController.getCurrencyRate(toComboBox.getValue());
    }

    @FXML
    private void updateCCInput() {
        double inputValue, outputValue;
        try {
            inputValue = Double.parseDouble(inputTextField.getText());
        } catch (Exception e) {
            inputValue = 0;
        }
        outputValue = inputValue * getOutputCurrencyRate() / getInputCurrencyRate();
        outputLabel.setText(String.format("%.2f", outputValue));
    }

    @FXML
    private void addNote() {
        String title = noteTitleField.getText();
        String content = noteContentArea.getText();
        if (!title.isEmpty()) {
            noteController.addNote(title, content);
            noteTitles.add(title);
            noteListContent.add(content);
        }
        noteListView.setItems(noteTitles);
        System.out.println(noteTitles.toString());
        System.out.println(noteListContent.toString());
        System.out.println(noteListView.getItems().toString());
    }
}
