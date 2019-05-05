import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Investment {
    DecimalFormat df = new DecimalFormat("#.00");

    private Map<BigDecimal, BigDecimal> ranges = new TreeMap<>();


    public Investment() {
        this.addRange(BigDecimal.ZERO, new BigDecimal(0.02));
        this.addRange(new BigDecimal(50000), new BigDecimal(0.03));
        this.addRange(new BigDecimal(20000), new BigDecimal(0.025));
    }


    public void addRange(BigDecimal range, BigDecimal interest) {
        ranges.put(range, interest);
    }

    private BigDecimal findValueForKey(BigDecimal key) {
        ranges.putIfAbsent(key, BigDecimal.ZERO);
        return ranges.get(key);
    }

    private BigDecimal findRangeOfStartCapital(BigDecimal startCapital) {
        BigDecimal lowerRange = BigDecimal.ZERO;
        if (startCapital.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        for (BigDecimal x : ranges.keySet()) {
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


    public Map<BigDecimal, BigDecimal> getRanges() {
        return ranges;
    }
}
