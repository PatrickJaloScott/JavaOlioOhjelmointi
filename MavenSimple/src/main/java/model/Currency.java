package model;

import java.util.HashMap;

public class Currency {
    private final String[] currencyAbbreviations = {"USD", "EUR", "GBP", "JPY", "CNY"},
    currencyNames = {"United States Dollar", "Euro", "Great Britain Pound", "Japanese Yen", "Chinese Yen"};
    private final HashMap<String, Double> currencyMap;
    private final HashMap<String, String> currencyNameMap;

    public Currency() {
        currencyMap = new HashMap<>();
        currencyNameMap = new HashMap<>();
        for (int i = 0; i < currencyAbbreviations.length; i++) {
            double[] currencyRates = {1.0, 0.95, 0.82, 149, 7.31};
            currencyMap.put(currencyAbbreviations[i], currencyRates[i]);
            currencyNameMap.put(currencyAbbreviations[i], currencyNames[i]);
        }
    }

    public String[] getCurrencyAbbreviations() {
        return currencyAbbreviations;
    }

    public double getRate(String currency) {
        return currencyMap.get(currency);
    }

    public String getCurrencyName(String abbreviation) {
        return currencyNameMap.get(abbreviation);
    }
}
