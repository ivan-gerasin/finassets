package finassets.core;

import finassets.core.assets.Money;

import java.util.*;

public class Portfolio {

    private String name;

    private final ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    Portfolio(String aName) {
        name = aName;
    }

    public String getName(){
        return name;
    }

    public int getSize() {
        return transactions.size();
    }

    public Optional<Transaction> get(final int index) {
        try {
            return Optional.of(transactions.get(index));
        } catch (IndexOutOfBoundsException err) {
            return Optional.empty();
        }
    }

    public void add(final Optional<Transaction> transaction) {
        transaction.ifPresent(transactions::add);
    }

    public Map<Currency, Double> reduceSameCurrency() {
        Map<Currency, Double> sum = new HashMap<Currency, Double>();
        for (Transaction item:transactions) {
            if (!item.isAssetOf(Money.class)) {
                continue;
            }
        }
    }

}
