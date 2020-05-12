package finassets.core;

import static org.junit.Assert.*;

import finassets.core.assets.Money;
import finassets.core.assets.Share;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class TransactionLogTest {
    private TransactionLog transactionLog;
    private Share testShare = new Share("SBER", "MOEX");
    private Money testSum = new Money(200, "RUB");

    @Before
    public void setUp() {
        this.transactionLog = new TransactionLog("Test portfolio");
    }

    @Test
    public void createEmptyPortfolioByDefault() {
        assertEquals(transactionLog.getSize(), 0);
        assertEquals(transactionLog.getName(), "Test portfolio");
    }

    @Test
    public void addNewTransaction() {
        Transaction transaction = new Transaction(testShare, 1, testSum);
        transactionLog.add(Optional.of(transaction));
        assertEquals(transactionLog.getSize(), 1);
        Optional<Transaction> addedTransaction = transactionLog.get(0);
        assertTrue(addedTransaction.isPresent());
        assertEquals(addedTransaction.get(), transaction);
    }

    @Test
    public void noErrorWhenOnOutOfBoundIndex() {
        Optional<Transaction> addedTransaction = transactionLog.get(99);
        assertFalse(addedTransaction.isPresent());
    }

    @Test
    public void getPortfolio() {
        assertEquals(0, transactionLog.getPortfolio().size());

        // Count only uniq assets
        Transaction firstTransaction = new Transaction(testShare, 2, testSum);
        transactionLog.add(Optional.of(firstTransaction));
        assertEquals(1, transactionLog.getPortfolio().size());

    }


}