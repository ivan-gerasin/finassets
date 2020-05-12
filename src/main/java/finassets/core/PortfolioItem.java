package finassets.core;

import finassets.core.assets.Asset;

public class PortfolioItem {
    final private int number;
    final private Asset asset;
    PortfolioItem(int aNumber, Asset anAsset) {
        assert anAsset != null;
        number = aNumber;
        asset = anAsset;
    }
}
