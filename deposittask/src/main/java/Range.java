import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Objects;

public class Range {

    private BigDecimal minCapital;
    private BigDecimal maxCapital;
    private BigDecimal interest;

    public Range(BigDecimal minCapital, BigDecimal maxCapital, BigDecimal interest) {
        if (minCapital.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid minimum Capital: " + minCapital);
        }
        if (maxCapital.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Invalid maximum Capital: " + maxCapital);
        }
        if (interest.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid interest: " + interest);
        }
        this.minCapital = minCapital;
        this.maxCapital = maxCapital;
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return minCapital.equals(range.minCapital) &&
                maxCapital.equals(range.maxCapital) &&
                interest.equals(range.interest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minCapital, maxCapital, interest);
    }

    public BigDecimal getMinCapital() {
        return minCapital;
    }


    public BigDecimal getMaxCapital() {
        return maxCapital;
    }


    public BigDecimal getInterest() {
        return interest;
    }

}

