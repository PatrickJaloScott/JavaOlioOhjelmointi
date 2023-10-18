package application.view;

import controller.CurrencyController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CurrencyConverterGUI extends Application {

    private CurrencyController controller;
    private final ChoiceBox<String> leftCurrency = new ChoiceBox<>();
    private final ChoiceBox<String> rightCurrency = new ChoiceBox<>();
    Label leftInputLabel;
    Label rightInputLabel;
    TextField rightAmount;
    Label inputCurrencyErrorLabel, outputCurrencyErrorLabel;
    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();

        // create ui elements for top section
        HBox top = new HBox();
        Label instructions = new Label("Select input and output currencies from the dropdown selectors and enter the input value into the left field.\nPress 'Convert' to show the value in the selected output currency.\nYou can navigate through the UI with the tab-key in the following progression:\nInput Currency -> Input Amount ->\nOutput Currency -> Convert Button");
        instructions.setMinHeight(60);
        instructions.setTextAlignment(TextAlignment.CENTER);
        instructions.setWrapText(true);
        instructions.setMinWidth(300);
        instructions.setAlignment(Pos.CENTER);

        // create ui elements for left section
        VBox left = new VBox();
        Label leftChoiceLabel = new Label("Choose input Currency");
        leftInputLabel = new Label("Input");
        TextField leftAmount = new TextField();
        leftAmount.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        inputCurrencyErrorLabel = new Label();
        leftCurrency.setOnAction(actionEvent -> {
            inputCurrencyErrorLabel.setText("");
            controller.setCurrencyLabelsWithNames();
        });

        // create ui elements for right section
        VBox right = new VBox();
        Label rightChoiceLabel = new Label("Choose output Currency");
        rightInputLabel = new Label("Output");
        rightAmount = new TextField();
        rightAmount.setDisable(true);
        outputCurrencyErrorLabel = new Label();
        rightCurrency.setOnAction(actionEvent -> {
            outputCurrencyErrorLabel.setText("");
            controller.setCurrencyLabelsWithNames();
        });

        // create ui elements for bottom section
        StackPane bottom = new StackPane();
        Button convert = new Button("Convert");
        convert.setOnAction(actionEvent -> {
            String inputText = leftAmount.getText().replace(",", ".");
            leftAmount.setText(inputText);
            controller.convert(inputText, leftCurrency.getValue(), rightCurrency.getValue());
        });

        // move all ui elements to layouts
        top.getChildren().add(instructions);
        top.setPadding(CurrencyViewSettings.PADDING);

        left.setAlignment(Pos.BASELINE_CENTER);
        left.setSpacing(CurrencyViewSettings.VERTICALSPACING);
        left.getChildren().addAll(leftChoiceLabel, leftCurrency, inputCurrencyErrorLabel, leftInputLabel, leftAmount);
        left.setPadding(CurrencyViewSettings.PADDING);

        right.setAlignment(Pos.BASELINE_CENTER);
        right.setSpacing(CurrencyViewSettings.VERTICALSPACING);
        right.getChildren().addAll(rightChoiceLabel, rightCurrency, outputCurrencyErrorLabel, rightInputLabel, rightAmount);
        right.setPadding(CurrencyViewSettings.PADDING);
        rightChoiceLabel.setAlignment(Pos.CENTER);

        bottom.getChildren().add(convert);
        bottom.setPadding(CurrencyViewSettings.PADDING);

        layout.setTop(top);
        top.setAlignment(Pos.CENTER);
        layout.setLeft(left);
        layout.setRight(right);
        layout.setCenter(bottom);
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(bottom, Pos.TOP_CENTER);

        // initiate scene
        Scene scene = new Scene(layout, CurrencyViewSettings.WINDOWDEFAULTWIDTH, CurrencyViewSettings.WINDOWDEFAULTHEIGHT);
        scene.getStylesheets().add("currency_style.css");
        stage.setScene(scene);
        stage.setTitle(CurrencyViewSettings.WINDOWTITLE);
        stage.show();
    }

    @Override
    public void init() {
        controller = new CurrencyController(this);
        controller.initiateChoiceBoxes();
    }

    public void setupChoiceBoxes(String[] entries) {
        leftCurrency.getItems().addAll(entries);
        rightCurrency.getItems().addAll(entries);
    }

    public String getInputCurrency() {
        return leftCurrency.getValue();
    }

    public String getOutputCurrency() {
        return rightCurrency.getValue();
    }

    public void setCurrencyLabels(String inputCurrency, String outputCurrency) {
        leftInputLabel.setText("Input " + inputCurrency);
        rightInputLabel.setText("Output " + outputCurrency);
    }

    public void setRightAmount(String currency) {
        rightAmount.setText(currency);
    }

    public void setSelectionError(String inputOrOutputCurrency) {
        String errorMessage = "Please select a currency!";
        if(inputOrOutputCurrency.equalsIgnoreCase("input")) {
            inputCurrencyErrorLabel.setText(errorMessage);
            inputCurrencyErrorLabel.setTextFill(CurrencyViewSettings.ERRORCOLOR);
        } else if (inputOrOutputCurrency.equalsIgnoreCase("output")) {
            outputCurrencyErrorLabel.setText(errorMessage);
            outputCurrencyErrorLabel.setTextFill(CurrencyViewSettings.ERRORCOLOR);
        }
    }
}
