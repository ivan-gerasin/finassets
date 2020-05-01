package finassets.core.assets;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShareTest {
    private final Share share = new Share("SBER", "MOEX");

    @Test
    public void displayName(){
        assertEquals(share.toString(), "MOEX:SBER");
    }
}
