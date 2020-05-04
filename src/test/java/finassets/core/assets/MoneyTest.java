package finassets.core.assets;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {
    private Money rub = new Money(100, "RUB");
    private Money czk = new Money(33.339, "CZK");
    private Money usd = new Money(0.799, "USD");


    @Test
    public void stringRepresentation() {
        assertEquals(rub.toString(), "100.00 RUB");
        assertEquals(czk.toString(), "33.34 CZK");
        assertEquals(usd.toString(), "0.80 $");
    }

    @Test
    public void canSumMoneyWithSameCurrency() {
        Money anotherRub = new Money(200, "RUB");
        try {
            Money sum = rub.sum(anotherRub);
            assertEquals(sum.getAmount(), 300.00, 0.001);
        } catch (DifferentCurrencyException err) {
            throw new RuntimeException("What the fuck?");
        }
    }

    @Test(expected = DifferentCurrencyException.class)
    public void throwExceptionWhenAddDifferentCurrency() throws DifferentCurrencyException {
        Money sum = rub.sum(czk);
    }

    @Test
    public void sumWorksWithNull() {
        try {
            Money sum = rub.sum(null);
        } catch (DifferentCurrencyException err) {
            throw new RuntimeException("What the fuck?");
        }
    }

    @Test
    public void qualityByValue() {
        Money sameRub = new Money(100, "RUB");
        assertTrue(sameRub.equals(rub));
    }
}
