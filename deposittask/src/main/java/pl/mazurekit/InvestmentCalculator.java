package pl.mazurekit;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

public class InvestmentCalculator {
    private static final DecimalFormat DF = new DecimalFormat("#0.00");

    private RangeFinder rangeFinder;

    public InvestmentCalculator(RangeFinder rangeFinder) {
        this.rangeFinder = rangeFinder;
    }

    public String calculateOneYearProfit(BigDecimal startCapital) {
        Optional<Range> properRangeForCapital = rangeFinder.findProperRangeForCapital(startCapital);
        if (startCapital.compareTo(BigDecimal.ZERO) == -1) {
            return DF.format(BigDecimal.ZERO);
        } else {
            if (properRangeForCapital.isPresent()) {
                return DF.format(
                        startCapital.multiply(
                                BigDecimal.ONE.add(properRangeForCapital.get().getInterest().divide(new BigDecimal(100)))));
            }
            return DF.format(startCapital);
        }
    }
}
