package org.example;

public final class AccountStateSavings {
    //private final @Getter String ownerName;
    //private final Map<Currency, Integer> currencyMap;
    public final String ownerName;
    public final String currencySaldoTextList;

    public AccountStateSavings(String ownerName, String currencySaldoTextList) {
        this.ownerName = ownerName;
        this.currencySaldoTextList = currencySaldoTextList;
    }
}