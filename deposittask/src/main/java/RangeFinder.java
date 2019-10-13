import java.math.BigDecimal;
import java.util.Optional;

public class RangeFinder {
    private RangeProvider rangeProvider;

    public RangeFinder(RangeProvider rangeProvider) {
        this.rangeProvider = rangeProvider;
    }

    public Optional<Range> findProperRangeForCapital(BigDecimal startCapital)  {
        for (Range range : rangeProvider.getAvailableRanges()) {
            if (isMoreThanMinRange(startCapital, range.getMinCapital()) && isLessThanOrEqualsMaxRange(startCapital, range.getMaxCapital())) {
                return Optional.of(range);
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
