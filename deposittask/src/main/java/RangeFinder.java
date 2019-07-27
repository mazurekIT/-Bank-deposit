import java.math.BigDecimal;
import java.util.Optional;

public class RangeFinder {
    private RangeProvider csvReader;

    public RangeFinder(RangeProvider csvReader) {
        this.csvReader = csvReader;
    }

    public Optional<Range> findProperRangeForCapital(BigDecimal startCapital) {
        for (Range csvrange : csvReader.getAvailableRanges()) {
            if (isMoreThanMinRange(startCapital, csvrange.getMinCapital()) && isLessThanOrEqualsMaxRange(startCapital, csvrange.getMaxCapital())) {
                return Optional.of(csvrange);
            }
        }
        return Optional.empty();
    }

    private boolean isMoreThanMinRange(BigDecimal capital, BigDecimal range) {
        return capital.compareTo(range) == 1;
    }

    private boolean isLessThanOrEqualsMaxRange(BigDecimal capital, BigDecimal range) {

        return capital.compareTo(range) <= 0;
    }

}
