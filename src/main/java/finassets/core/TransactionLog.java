package finassets.core;

import finassets.core.assets.Asset;

import java.util.*;

public class TransactionLog {

    private String name;

    private final ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    TransactionLog(String aName) {
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

    public Portfolio getPortfolio() {
        HashMap<Asset, Integer> assetAccumulator = new HashMap<>();
        transactions.forEach(transaction -> assetAccumulator.put(transaction.getAsset(), 1));
        return new Portfolio(assetAccumulator);
    }

}
