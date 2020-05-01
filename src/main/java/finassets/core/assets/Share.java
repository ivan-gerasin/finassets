package finassets.core.assets;

public class Share extends Security {
    private final String ticker;
    private final String stockExchange;

    public Share(final String aTicker, final String aStockExchange) {
        ticker = aTicker;
        stockExchange = aStockExchange;
    }

    public String toString() {
        return String.format("%s:%s", stockExchange, ticker);
    }
}
