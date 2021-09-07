package com.gdr.forex;

public class CurrencyLookupException extends Exception {
    private Currency currency;

    public CurrencyLookupException(String message, Currency currency) {
        super(message);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
