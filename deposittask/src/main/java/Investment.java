import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Investment {
    DecimalFormat df = new DecimalFormat("#.00");

    private Map<BigDecimal, BigDecimal> ranges = new TreeMap<>();


    public void addRange(BigDecimal range, BigDecimal interest) {
        ranges.put(range, interest);
    }

    private Set<BigDecimal> getKeySet() {
        return ranges.keySet();
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
        for (BigDecimal x : getKeySet()) {
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
