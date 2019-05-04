import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvestmentTest {
    DecimalFormat df = new DecimalFormat("#.00");


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Investment().calculateOneYearProfit(new BigDecimal(-10));
        });
    }

    @Test
    public void shouldBeInFirstRange() {
        assertEquals(df.format(new BigDecimal(20400)), new Investment().calculateOneYearProfit(new BigDecimal(20000)));
    }


    @Test
    public void shouldBeInSecondRange() {
        assertEquals(df.format(new BigDecimal(51250)), new Investment().calculateOneYearProfit(new BigDecimal(50000)));
    }

    @Test
    public void shouldBeInThirdRange() {
        assertEquals(df.format(new BigDecimal(103000)), new Investment().calculateOneYearProfit(new BigDecimal(100000)));
    }


}


