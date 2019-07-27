import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

public class InvestmentCalculator {
    private static final DecimalFormat DF = new DecimalFormat("#.00");

    private RangeFinder rangeFinder;

    public InvestmentCalculator(RangeFinder rangeFinder) {
        this.rangeFinder = rangeFinder;
    }

    public String calculateOneYearProfit(BigDecimal startCapital) {
        Optional<Range> properRangeForCapital = rangeFinder.findProperRangeForCapital(startCapital);
        if (properRangeForCapital.isPresent()) {
            return DF.format(startCapital.multiply(BigDecimal.ONE.add(properRangeForCapital.get().getInterest())));
        }
        return DF.format(startCapital);
    }


}
