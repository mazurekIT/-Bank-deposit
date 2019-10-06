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
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Optional<Range> optionalRange = Optional.of(firstRange);
        Mockito.when(rangeFinder.findProperRangeForCapital(any(BigDecimal.class))).thenReturn(optionalRange);

    }


    @Test
    public void shouldCalculateProperlyOneYearProfit() {
        String expectedProfit = DF.format(new BigDecimal(5100));
        String actualProfit = investmentCalculator.calculateOneYearProfit(new BigDecimal(5000));
        assertEquals(expectedProfit, actualProfit);

    }


}


