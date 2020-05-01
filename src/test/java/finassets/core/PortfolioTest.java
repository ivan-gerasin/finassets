package finassets.core;

import static org.junit.Assert.*;

import finassets.core.assets.Money;
import finassets.core.assets.Share;
import org.junit.Before;
import org.junit.Test;

import java.util.Currency;
import java.util.Map;
import java.util.Optional;

public class PortfolioTest {
    private Portfolio portfolio;
    private Share testShare = new Share("SBER", "MOEX");
    private Money testSum = new Money(200, "RUB");

    @Before
    public void setUp() {
        this.portfolio = new Portfolio("Test portfolio");
    }

    @Test
    public void createEmptyPortfolioByDefault() {
        assertEquals(portfolio.getSize(), 0);
        assertEquals(portfolio.getName(), "Test portfolio");
    }

    @Test
    public void addNewTransaction() {
        Transaction transaction = new Transaction(testShare, 1, testSum);
        portfolio.add(Optional.of(transaction));
        assertEquals(portfolio.getSize(), 1);
        Optional<Transaction> addedTransaction = portfolio.get(0);
        assertTrue(addedTransaction.isPresent());
        assertEquals(addedTransaction.get(), transaction);
    }

    @Test
    public void noErrorWhenOnOutOfBoundIndex() {
        Optional<Transaction> addedTransaction = portfolio.get(99);
        assertFalse(addedTransaction.isPresent());
    }

    @Test
    public void reducePortfolioToBunchOfMoney() {
        Share rubShare = testShare; //MOEX:SBER Rub
        Share usdShare = new Share("APPL", "NASDAQ");
        Money rubSum = testSum;
        Money usdSum = new Money(100, "USD");

        Transaction rubTransaction = new Transaction(rubShare, 1, rubSum);
        Transaction usdTransaction = new Transaction(usdShare, 2, usdSum);
        portfolio.add(Optional.of(rubTransaction));
        portfolio.add(Optional.of(usdTransaction));

        Map<Currency, Double> monies = portfolio.reduceSameCurrency();
        assertEquals(monies.size(), 2);
        assertEquals(monies.get(Currency.getInstance("RUB")), new Double(200));
    }


}