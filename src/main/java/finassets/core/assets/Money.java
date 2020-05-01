package finassets.core.assets;


import java.util.Currency;

public class Money extends Asset {
    private final Currency currency;
    private final double amount;

    public Money(final double anAmount, final String currencyCode) {
        currency = Currency.getInstance(currencyCode);
        amount = anAmount;
    }
}
