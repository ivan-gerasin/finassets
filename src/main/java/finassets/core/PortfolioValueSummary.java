package finassets.core;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class PortfolioValueSummary {
    final private Map<Currency, Double> store = new HashMap<Currency, Double>();

    static public PortfolioValueSummary from(Portfolio portfolio) {
        return new PortfolioValueSummary();
    }

    public int getSize() {
        return store.size();
    }
}
