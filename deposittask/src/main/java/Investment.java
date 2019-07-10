import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Investment {
    DecimalFormat df = new DecimalFormat("#.00");


    public String calculateOneYearProfit(BigDecimal startCapital) {
        RangeFinder rangeFinder = new RangeFinder();
        Range properRangeForCapital = rangeFinder.findProperRangeForCapital(startCapital);
        return df.format(startCapital.multiply(BigDecimal.ONE.add(properRangeForCapital.getInterest())));
    }

}
