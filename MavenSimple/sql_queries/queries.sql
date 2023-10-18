USE currencydb;
SELECT * FROM currency;

SELECT currencyname, rate FROM currency WHERE abbreviation = 'EUR';

SELECT COUNT(id) FROM currency;

SELECT MAX(rate) FROM currency;