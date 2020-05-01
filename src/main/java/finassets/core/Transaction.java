package finassets.core;

import finassets.core.assets.Asset;
import finassets.core.assets.Decimal;
import org.jetbrains.annotations.Contract;

import java.util.Date;
import java.util.Currency;

public class Transaction {
    private final Date dateTime;
    private final Asset asset;
    private final int number;
    private final Currency price;

    @Contract(pure = true)
    Transaction(final Asset anAsset, final int aNumber, final Currency aPrice) {
        dateTime = new Date();
        asset = anAsset;
        number = aNumber;
        price = aPrice;
    }

    @Contract(pure = true)
    Transaction(final Asset anAsset, final int aNumber, final Currency aPrice, final Date aDate) {
        dateTime = aDate;
        asset = anAsset;
        number = aNumber;
        price = aPrice;
    }

    
    
}