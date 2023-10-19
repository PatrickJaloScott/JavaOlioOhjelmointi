package application.view;

import application.controller.CurrencyController2;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;

public class FXMLController {
    private final CurrencyController2 controller;
    @FXML
    private ChoiceBox<String> fromChoiceBox;
    @FXML
    private ComboBox<String> toComboBox;
    @FXML
    private TextField inputTextField;
    @FXML
    private Label outputLabel;

    public FXMLController() {
        controller = new CurrencyController2();
    }

    public void initiate() {
        String[] currencyAbbreviations = controller.getCurrencies();
        inputTextField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        fromChoiceBox.getItems().addAll(currencyAbbreviations);
        fromChoiceBox.setValue(fromChoiceBox.getItems().get(0));
        toComboBox.getItems().addAll(currencyAbbreviations);
        toComboBox.setValue(toComboBox.getItems().get(1));
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
