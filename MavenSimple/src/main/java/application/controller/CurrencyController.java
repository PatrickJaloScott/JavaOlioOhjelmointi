package application.controller;

import dao.CurrencyDao;

public class CurrencyController {
    public CurrencyController() {}
    public String[] getCurrencies() {
        return CurrencyDao.getCurrencyAbbreviations();
    }

    public double getCurrencyRate(String abbreviation) {
        return CurrencyDao.getCurrencyRate(abbreviation);
    }
}
