package application.controller;

import model.Currency;
import view.CurrencyConverterGUI;

public class CurrencyController {
    private final CurrencyConverterGUI gui;
    private final Currency model;

    public CurrencyController(CurrencyConverterGUI gui) {
        this.gui = gui;
        this.model = new Currency();
    }

    public static void main(String[] args) {
        CurrencyConverterGUI.launch(CurrencyConverterGUI.class);
    }

    public void convert(String input, String inputCurrency, String outputCurrency) {
        double inputValue, rate;
        try {
            inputValue = Double.parseDouble(input);
        } catch (NumberFormatException numberFormatException) {
            inputValue = 0;
        }
        if (inputCurrency != null && outputCurrency != null) {
            rate = inputValue * model.getRate(outputCurrency) / model.getRate(inputCurrency);
            gui.setRightAmount(String.format("%.2f", rate));
        } else {
            if (inputCurrency == null || inputCurrency.isEmpty()) {
                gui.setSelectionError("input");
            }
            if (outputCurrency == null || outputCurrency.isEmpty()) {
                gui.setSelectionError("output");
            }
        }
    }

    public void setCurrencyLabelsWithNames() {
        String input, output;
        input = model.getCurrencyName(gui.getInputCurrency());
        output = model.getCurrencyName(gui.getOutputCurrency());
        gui.setCurrencyLabels(input, output);
    }

    public void initiateChoiceBoxes() {
        gui.setupChoiceBoxes(model.getCurrencyAbbreviations());
    }
}