package finassets.core;

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

    public Map<Currency, Double> reduceWithSameCurrency() {
        Map<Currency, Double> sum = new HashMap<Currency, Double>();
        for (Transaction item:transactions) {
            Currency currency = item.getCurrency();
            double amount = item.getPrice().getAmount();
            sum.replace(currency, sum.get(currency) + amount);

        }
        return sum;
    }

}
