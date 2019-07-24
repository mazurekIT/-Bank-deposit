import java.math.BigDecimal;

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

//    public Range() {
//        this.interest = BigDecimal.ZERO;
//    }


    public Range() {
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

