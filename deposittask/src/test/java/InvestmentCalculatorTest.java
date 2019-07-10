import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvestmentCalculatorTest {
    private DecimalFormat df = new DecimalFormat("#.00");
    private InvestmentCalculator investmentCalculator = new InvestmentCalculator();
//
//    @Test
//    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            investment.calculateOneYearProfit(new BigDecimal(-10));
//        });
//    }
//
    @Test
    public void shouldReturnZeroForCapitalEqualsZero() {
        String expectedProfit = ",00";
        Capital capitalZero = new Capital(BigDecimal.ZERO);
        String calculateProfit = investmentCalculator.calculateOneYearProfit(capitalZero.getCapitalValue());

        assertEquals(expectedProfit, calculateProfit);

    }


    @Test
    public void shouldCountAtFirstRange(){
        String expectedProfit = "1020,00";
        Capital capital = new Capital(new BigDecimal("1000"));
        String calculatedProfit = investmentCalculator.calculateOneYearProfit(capital.getCapitalValue());
        assertEquals(expectedProfit,calculatedProfit);
    }

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


