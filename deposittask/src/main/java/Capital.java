import java.math.BigDecimal;

public class Capital {

    private BigDecimal capitalValue;


    public Capital(BigDecimal capitalValue) {
        if (capitalValue.compareTo(BigDecimal.ZERO)<1){
            throw new IllegalArgumentException("Invalid capital: "+ capitalValue);
        }
        this.capitalValue = capitalValue;
    }


    public BigDecimal getCapitalValue() {
        return capitalValue;
    }

}
