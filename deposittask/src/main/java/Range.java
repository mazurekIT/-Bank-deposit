import java.math.BigDecimal;

public class Range {

    private BigDecimal minCapital;
    private BigDecimal maxCapital;
    private BigDecimal interest;

    public Range(BigDecimal minCapital, BigDecimal maxCapital, BigDecimal interest) {
        this.minCapital = minCapital;
        this.maxCapital = maxCapital;
        this.interest = interest;
    }

    public Range() {
        this.interest = BigDecimal.ZERO;
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

