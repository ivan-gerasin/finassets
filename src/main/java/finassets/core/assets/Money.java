package finassets.core.assets;


import java.util.Currency;

public class Money extends Asset {
    private final Currency currency;
    private final double amount;

    public Money(final double anAmount, final String currencyCode) {
        currency = Currency.getInstance(currencyCode);
        amount = anAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency.getSymbol());
    }

    public Money sum(Money aMoney) throws DifferentCurrencyException {
        if (aMoney == null) {
            return this;
        }
        String currentCode = currency.getCurrencyCode();
        String incomingCurrencyCode = aMoney.getCurrency().getCurrencyCode();
        if (currentCode.equals(incomingCurrencyCode)) {
            return new Money(amount+aMoney.getAmount(), currentCode);
        }
        String errMsg = String.format("Different currency: %s and new one - %s", currentCode, incomingCurrencyCode);
        throw new DifferentCurrencyException(errMsg);
    }

    public boolean equals(Money other) {
        return amount == other.amount && currency == other.currency;
    }
}

class DifferentCurrencyException extends Exception {
    DifferentCurrencyException(String msg) {
        super(msg);
    }
}
