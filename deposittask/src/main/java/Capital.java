import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Capital {
//    DecimalFormat df = new DecimalFormat("#.00");

    private BigDecimal capitalValue;


    public Capital(BigDecimal capitalValue) {
        this.capitalValue = capitalValue;
    }



    public BigDecimal getCapitalValue() {
        return capitalValue;
    }

    public void setCapitalValue(BigDecimal capitalValue) {
        this.capitalValue = capitalValue;
    }
}
