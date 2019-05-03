import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Investment {
    private BigDecimal interestOfFirstRange = new BigDecimal(0.02);
    private BigDecimal interestOfSecondRange = new BigDecimal(0.025);
    private BigDecimal interestOfThirdRange = new BigDecimal(0.03);

    private BigDecimal firstRange = new BigDecimal(20000);
    private BigDecimal secondRange = new BigDecimal(50000);
    DecimalFormat df = new DecimalFormat("#.00");


    public String calculateOneYearProfit(BigDecimal startCapital) {

        if (startCapital.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        } else if (startCapital.compareTo(firstRange) <= 0) {
            return calculateFinalCapital(startCapital, interestOfFirstRange);
        } else if (startCapital.compareTo(secondRange) <= 0) {
            return calculateFinalCapital(startCapital, interestOfSecondRange);
        } else {
            return calculateFinalCapital(startCapital, interestOfThirdRange);
        }

    }


    public String calculateFinalCapital(BigDecimal startCapital, BigDecimal interest) {
        return df.format(startCapital.add(startCapital.multiply(interest)));
    }

}
