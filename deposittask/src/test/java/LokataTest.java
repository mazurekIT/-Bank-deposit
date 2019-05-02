import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LokataTest {
    DecimalFormat df = new DecimalFormat("#.00");


    @Test
    public void shouldByBadReturn() {
        assertEquals("Zła kwota",new Lokata().zyskRoczny(new BigDecimal(-10)));
    }

    @Test
    public void shouldByInFirst() {
        assertEquals(df.format(new BigDecimal(20400)),new Lokata().zyskRoczny(new BigDecimal(20000)));
    }


    @Test
    public void shouldByInSecond() {
        assertEquals(df.format(new BigDecimal(51250)),new Lokata().zyskRoczny(new BigDecimal(50000)));
    }

    @Test
    public void shouldByInThird() {
        assertEquals(df.format(new BigDecimal(103000)),new Lokata().zyskRoczny(new BigDecimal(100000)));
    }


}


