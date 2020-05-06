package finassets.core;

import finassets.core.assets.Asset;
import finassets.core.assets.Money;

import java.util.Currency;
import java.util.Date;

public class Transaction {
    private final Date dateTime;
    private final Asset asset;
    private final int number;
    private final Money price;

    Transaction(final Asset anAsset, final int aNumber,  Money aPrice) {
        dateTime = new Date();
        asset = anAsset;
        number = aNumber;
        price = aPrice;
    }

    Transaction(final Asset anAsset, final int aNumber, final Money aPrice, final Date aDate) {
        dateTime = aDate;
        asset = anAsset;
        number = aNumber;
        price = aPrice;
    }

    public boolean isAssetOf(final Class anAssetType) {
        return anAssetType.isInstance(this.asset);
    }

    public Money getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return price.getCurrency();
    }

    public boolean equals(Transaction other) {
        if (this == other) return true;
        if (other == null) return false;

        return  dateTime.equals(other.dateTime) &&
                asset.equals(other.asset) &&
                number == other.number &&
                price.equals(other.price);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + dateTime.hashCode();
        hash = 31 * hash + asset.hashCode();
        hash = 31 * hash + number;
        hash = 31 * hash + price.hashCode();
        return hash;
    }
}

class MissingAssetInTransactionException extends Exception {}
class MissingPriceInTransactionException extends Exception {}