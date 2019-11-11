package pl.mazurekit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class InvestmentCalculatorTest {
    private static final DecimalFormat DF = new DecimalFormat("#.00");


    @Mock
    RangeFinder rangeFinder;

    @InjectMocks
    InvestmentCalculator investmentCalculator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldCalculateProperlyOneYearProfit() {
        Range range = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Optional<Range> optionalRange = Optional.of(range);
        Mockito.when(rangeFinder.findProperRangeForCapital(any(BigDecimal.class))).thenReturn(optionalRange);

        String expectedProfit = DF.format(new BigDecimal(5100));
        String actualProfit = investmentCalculator.calculateOneYearProfit(new BigDecimal(5000));
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    public void shouldCalculateProperlyOneYearProfitWhenCapitalIsOutOfRange() {
        Optional<Range> range = Optional.empty();
        Mockito.when(rangeFinder.findProperRangeForCapital(any(BigDecimal.class))).thenReturn(range);

        String expectedProfit = DF.format(new BigDecimal(15000));
        String actualProfit = investmentCalculator.calculateOneYearProfit(new BigDecimal(15000));
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    public void shouldCalculateProperlyOneYearProfitWhenCapitalIsNegative() {
        Optional<Range> range = Optional.empty();
        Mockito.when(rangeFinder.findProperRangeForCapital(any(BigDecimal.class))).thenReturn(range);

        String actualProfit = investmentCalculator.calculateOneYearProfit(new BigDecimal(-150));
        assertEquals("0,00", actualProfit);
    }

}


