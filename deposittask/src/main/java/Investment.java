import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Investment {
    DecimalFormat df = new DecimalFormat("#.00");

    CSVService csv = new CSVService("progi.csv");


    private BigDecimal findValueForKey(BigDecimal key) {
        csv.getRanges().putIfAbsent(key, BigDecimal.ZERO);
        return csv.getRanges().get(key);
    }

    private BigDecimal findRangeOfStartCapital(BigDecimal startCapital) {
        BigDecimal lowerRange = BigDecimal.ZERO;
        if (startCapital.compareTo(lowerRange) < 0) {
            throw new IllegalArgumentException();
        }
        for (BigDecimal x : csv.getRanges().keySet()) {
            if (startCapital.compareTo(x) > 0) {
                lowerRange = x;
            }
        }
        return lowerRange;
    }

    public String calculateOneYearProfit(BigDecimal startCapital) {
        BigDecimal interest = findValueForKey(findRangeOfStartCapital(startCapital));

        return df.format(startCapital.multiply(BigDecimal.ONE.add(interest)));
    }

}
