DROP DATABASE if EXISTS currencydb;
CREATE DATABASE currencydb;

USE currencydb;
CREATE TABLE currency(
id INT NOT NULL AUTO_INCREMENT,
currencyname VARCHAR(40) NOT NULL,
abbreviation VARCHAR(5) NOT NULL,
rate DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO currencydb.currency VALUES
(1, 'United States Dollar', 'USD', 1.0),
(2, 'Euro', 'EUR', 0.95),
(3, 'Great Britain Pound', 'GBP', 0.82),
(4, 'Japanese Yen', 'JPY', 149),
(5, 'Chinese Yen', 'CNY', 7.31),
(6, 'Swedish Krona', 'SEK', 10.99),
(7, 'Canadian Dollar', 'CAD', 1.37),
(8, 'Russian Ruble', 'RUB', 97.75);

USE currencydb;
DROP USER if EXISTS 'appuserOCT23'@'localhost';
CREATE USER 'appuserOCT23'@'localhost' IDENTIFIED BY 'salasana';
GRANT SELECT ON currencydb.currency TO 'appuserOCT23'@'localhost';