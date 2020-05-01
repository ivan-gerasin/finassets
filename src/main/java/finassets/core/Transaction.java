package finassets.core;

import finassets.core.assets.Asset;
import finassets.core.assets.Money;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

public class Transaction {
    private final Date dateTime;
    private final Asset asset;
    private final int number;
    private final Money price;

    Transaction(final Asset anAsset, final int aNumber, final Money aPrice) {
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
    
}