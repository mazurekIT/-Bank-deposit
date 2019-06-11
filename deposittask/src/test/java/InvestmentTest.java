import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvestmentTest {
    private DecimalFormat df = new DecimalFormat("#.00");
    private Investment investment = new Investment();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            investment.calculateOneYearProfit(new BigDecimal(-10));
        });
    }

    @Test
    public void shouldReturnZeroForCapitalEqualsZero() {
        String expectedProfit = ",00";
        BigDecimal capitalZero = BigDecimal.ZERO;
        String calculateProfit = investment.calculateOneYearProfit(capitalZero);

        assertEquals(expectedProfit, calculateProfit);

    }


//    @Test
//    public void shouldCountAtFirstRange(){
//        String expectedProfit = "1020,00";
//        BigDecimal capital = new BigDecimal("1000");
//        String calculatedProfit = investment.calculateOneYearProfit(capital);
//        assertEquals(expectedProfit,calculatedProfit);
//    }

//    @Test
//    public void shouldPassEveryRange() {
//        for (BigDecimal x : investment.getRanges().keySet()) {
//            BigDecimal profit = BigDecimal.ONE.add(investment.getRanges().get(x));
//            String calculatedProfit = investment.calculateOneYearProfit(x.add(BigDecimal.ONE));
//            String expectedProfit = df.format((x.add(BigDecimal.ONE)).multiply(profit));
//
//            assertEquals(expectedProfit, calculatedProfit);
//        }
//    }


}


