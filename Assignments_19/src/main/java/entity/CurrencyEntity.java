package entity;

import jakarta.persistence.*;

@Entity
@Table(name="currency")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="currencyname")
    private String name;
    @Column(name="abbreviation")
    private String abbreviation;
    @Column(name="rate")
    private double exchangeRate;

    public CurrencyEntity() {}

    public CurrencyEntity(String name, String abbreviation, double exchangeRate) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.exchangeRate = exchangeRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
