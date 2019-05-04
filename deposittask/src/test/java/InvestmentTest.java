import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvestmentTest {
    private DecimalFormat df = new DecimalFormat("#.00");
    private Investment investment = new Investment();


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Investment().calculateOneYearProfit(new BigDecimal(-10));
        });
    }


    @Test
    public void shouldReturnTheSameCapitalWhenRangeIsNotAdded() {
        assertEquals(df.format(new BigDecimal(10)), investment.calculateOneYearProfit(new BigDecimal(10)));
    }


}


