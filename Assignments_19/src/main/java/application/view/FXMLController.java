package application.view;

import application.controller.CurrencyController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
    private final CurrencyController controller;
    @FXML
    private ChoiceBox<String> fromChoiceBox;
    @FXML
    private ComboBox<String> toComboBox;
    @FXML
    private TextField inputTextField;
    @FXML
    private Label outputLabel;

    public FXMLController() {
        controller = new CurrencyController();
    }

    public void initiate() {
        String[] currencyAbbreviations = controller.getCurrencies();
        fromChoiceBox.getItems().addAll(currencyAbbreviations);
        toComboBox.getItems().addAll(currencyAbbreviations);
    }

    private double getInputCurrencyRate() {
        return controller.getCurrencyRate(fromChoiceBox.getValue());
    }

    private double getOutputCurrencyRate() {
        return controller.getCurrencyRate(toComboBox.getValue());
    }

    @FXML
    private void updateInput() {
        double inputValue, outputValue;
        try {
            inputValue = Double.parseDouble(inputTextField.getText());
        } catch (Exception e) {
            inputValue = 0;
        }
        outputValue = inputValue * getOutputCurrencyRate() / getInputCurrencyRate();
        outputLabel.setText(String.format("%.2f", outputValue));
    }
}
