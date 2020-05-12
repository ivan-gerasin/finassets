package finassets.core;

import finassets.core.assets.Asset;

import java.util.ArrayList;
import java.util.HashMap;


public class Portfolio {

    private ArrayList<PortfolioItem> assets = new ArrayList<>();

    Portfolio(HashMap<Asset, Integer> anAssets) {
        for (HashMap.Entry<Asset, Integer> item : anAssets.entrySet()) {
            Asset asset = item.getKey();
            int number = item.getValue();
            assets.add(new PortfolioItem(number, asset));
        }
    }

    public int size() {
        return assets.size();
    }

}
