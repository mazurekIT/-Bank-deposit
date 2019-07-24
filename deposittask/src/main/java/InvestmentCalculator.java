import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

public class InvestmentCalculator {
    private final DecimalFormat DF = new DecimalFormat("#.00");


    public String calculateOneYearProfit(BigDecimal startCapital) {
        RangeFinder rangeFinder = new RangeFinder("progi.csv");
        Optional<Range> properRangeForCapital= rangeFinder.findProperRangeForCapital(startCapital);
        if(properRangeForCapital.isPresent()){
            return DF.format(startCapital.multiply(BigDecimal.ONE.add(properRangeForCapital.get().getInterest())));
        }
        return "brak zdeklarowanych progów";
    }


}
