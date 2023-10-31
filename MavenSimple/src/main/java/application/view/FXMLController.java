package application.view;

import application.controller.CurrencyController;
import application.controller.DictionaryController;
import application.controller.NoteController;
import javafx.scene.canvas.Canvas;
import programs.calculators.QuadraticSolver;
import programs.calculators.ThreeNumbersCalculator;
import programs.demo.Pyramid;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class FXMLController {
    // Main GUI
    @FXML
    private TextArea mainTextArea;

    // Calculator GUI
    ThreeNumbersCalculator threeNumbersCalculator;
    @FXML
    private TextField basicCalcNum1;
    @FXML
    private TextField basicCalcNum2;
    @FXML
    private TextField basicCalcNum3;
    @FXML
    private TextField basicCalcSum;
    @FXML
    private TextField basicCalcProduct;
    @FXML
    private TextField basicCalcAvg;
    @FXML
    private TextField quadraticAField;
    @FXML
    private TextField quadraticBField;
    @FXML
    private TextField quadraticCField;
    @FXML
    private Label quadraticFormulaLabel;

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
    private final NoteController noteController;
    @FXML
    private ListView<String> noteListView;
    private ObservableList<String> noteTitles, noteListContent;
    @FXML
    private TextField noteTitleField;
    @FXML
    private TextArea noteContentArea;
    @FXML
    private Button addNoteButton;

    // Dictionary GUI
    private final DictionaryController dictionaryController;
    @FXML
    private TextField dictionaryNewWordField;
    @FXML
    private TextArea dictionaryNewWordDef;
    @FXML
    private Button dictionarySaveButton;
    @FXML
    private TextField dictionarySearchField;
    @FXML
    private Label dictionaryErrorLabel;
    @FXML
    private Label dictionaryDefinitionLabel;

    // Lounge GUI
    @FXML
    private Canvas shapeCanvas;

    public FXMLController() {
        threeNumbersCalculator = new ThreeNumbersCalculator(0, 0, 0);

        currencyController = new CurrencyController();
        noteController = new NoteController();
        dictionaryController = new DictionaryController();
    }

    public void initiate() {
        // Main setup
        Pyramid pyramid = new Pyramid();
        mainTextArea.setText(pyramid.getPyramid());

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

    // Calculator methods
    @FXML
    private void basicCalcSolve() {
        int num1 = Integer.parseInt(basicCalcNum1.getText());
        int num2 = Integer.parseInt(basicCalcNum2.getText());
        int num3 = Integer.parseInt(basicCalcNum3.getText());
        threeNumbersCalculator.setValues(num1, num2, num3);
        basicCalcSum.setText("Sum = " + threeNumbersCalculator.sum());
        basicCalcProduct.setText("Product = " + threeNumbersCalculator.product());
        basicCalcAvg.setText("Average = " + threeNumbersCalculator.average());
    }

    @FXML
    private void solveQuadraticFormula() {
        int a = Integer.parseInt(quadraticAField.getText());
        int b = Integer.parseInt(quadraticBField.getText());
        int c = Integer.parseInt(quadraticCField.getText());
        quadraticFormulaLabel.setText(QuadraticSolver.formula() + "\n" + QuadraticSolver.result(a, b, c));
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

    @FXML
    private void addDictionaryDefinition() {
        String word = dictionaryNewWordField.getText();
        String definition = dictionaryNewWordDef.getText();
        if (!word.isEmpty() && !definition.isEmpty()) {
            dictionaryController.addEntry(word, definition);
            dictionaryNewWordField.setText("");
            dictionaryNewWordDef.setText("");
        } else {
            dictionaryErrorLabel.setText("Please enter a word and definition");
            dictionaryErrorLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    private void getDictionaryDefinition() {
        String word = dictionarySearchField.getText();
        if(!word.isEmpty()) {
            String definition = dictionaryController.getDefinition(word);
            if (definition == null) {
                dictionaryErrorLabel.setText("Could not find " + word);
                dictionaryErrorLabel.setTextFill(Color.RED);
            } else {
                dictionaryDefinitionLabel.setText(word + " - " + definition);
                dictionaryDefinitionLabel.setTextFill(Color.BLACK);
            }
        } else {
            dictionaryErrorLabel.setText("Please enter a word");
            dictionaryErrorLabel.setTextFill(Color.BLUE);
        }
    }
}
