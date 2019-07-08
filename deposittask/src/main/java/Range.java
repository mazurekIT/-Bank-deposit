import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Range {
//    DecimalFormat df = new DecimalFormat("#.00");

    private BigDecimal minCapital;
    private BigDecimal maxCapital;
    private BigDecimal interest;

    public Range(BigDecimal minCapital, BigDecimal maxCapital, BigDecimal interest) {
        this.minCapital = minCapital;
        this.maxCapital = maxCapital;
        this.interest = interest;
    }

    public Range() {
    }

    public BigDecimal getMinCapital() {
        return minCapital;
    }

    public void setMinCapital(BigDecimal minCapital) {
        this.minCapital = minCapital;
    }

    public BigDecimal getMaxCapital() {
        return maxCapital;
    }

    public void setMaxCapital(BigDecimal maxCapital) {
        this.maxCapital = maxCapital;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
}

