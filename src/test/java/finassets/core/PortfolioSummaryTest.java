package finassets.core;

import finassets.core.Portfolio;
import finassets.core.PortfolioValueSummary;
import finassets.core.assets.Money;
import finassets.core.assets.Share;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PortfolioSummaryTest {
    private Portfolio portfolio;
    private Share testShare = new Share("SBER", "MOEX");
    private Money testSum = new Money(200, "RUB");

    @Before
    public void setUp() {
        this.portfolio = new Portfolio("Test portfolio");
    }


    @Test
    public void emptyForEmptyPortfolio() {
        PortfolioValueSummary summary = PortfolioValueSummary.from(portfolio);
        assertEquals(summary.getSize(), 0);
    }

    @Test
    public void buildFromPortfolio() {
        Transaction transaction = new Transaction(testShare, 1, testSum);
        portfolio.add(Optional.of(transaction));
        PortfolioValueSummary summary = PortfolioValueSummary.from(portfolio);
        assertEquals(summary.getSize(), 1);
    }
}
