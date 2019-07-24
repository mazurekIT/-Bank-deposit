import java.math.BigDecimal;

public class Capital {

    private BigDecimal value;

    public Capital(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Invalid capital: " + value);
        }
        this.value = value;
    }


    public BigDecimal getValue() {
        return value;
    }

}
