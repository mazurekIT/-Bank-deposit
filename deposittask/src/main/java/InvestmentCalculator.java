import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InvestmentCalculator {
    DecimalFormat df = new DecimalFormat("#.00");


    public String calculateOneYearProfit(BigDecimal startCapital) {

        if (isCapitalGreaterThanZero(startCapital)){
            RangeFinder rangeFinder = new RangeFinder();
            Range properRangeForCapital = rangeFinder.findProperRangeForCapital(startCapital);
            return df.format(startCapital.multiply(BigDecimal.ONE.add(properRangeForCapital.getInterest())));
        } else{
            return "Kapitał jest mniejszy lub równy ZERO";
        }

    }

    private boolean isCapitalGreaterThanZero (BigDecimal capital){
        return capital.compareTo(BigDecimal.ZERO)==1;
    }

}
