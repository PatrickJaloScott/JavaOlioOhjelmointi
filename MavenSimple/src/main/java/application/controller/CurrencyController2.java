package application.controller;

import dao.CurrencyDao;

public class CurrencyController2 {
    public CurrencyController2() {}
    public String[] getCurrencies() {
        return CurrencyDao.getCurrencyAbbreviations();
    }

    public double getCurrencyRate(String abbreviation) {
        return CurrencyDao.getCurrencyRate(abbreviation);
    }
}
