import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Lokata {
    private BigDecimal oprocentowaniePierwszyProg = new BigDecimal(0.02);
    private BigDecimal oprocentowanieDrugiProg = new BigDecimal(0.025);
    private BigDecimal oprocentowanieTrzeciProg = new BigDecimal(0.03);

    private BigDecimal pierwszyProg = new BigDecimal(20000);
    private BigDecimal drugiProg = new BigDecimal(50000);
    DecimalFormat df = new DecimalFormat("#.00");


    public String zyskRoczny(BigDecimal kapitalPoczatkowy) {

        if (kapitalPoczatkowy.compareTo(BigDecimal.ZERO) <= 0) {
            return "Zła kwota";
        } else if (kapitalPoczatkowy.compareTo(pierwszyProg) <= 0) {
            return df.format(kapitalPoczatkowy.add(kapitalPoczatkowy.multiply(oprocentowaniePierwszyProg)));
        } else if (kapitalPoczatkowy.compareTo(drugiProg) <= 0) {
            return df.format(kapitalPoczatkowy.add(kapitalPoczatkowy.multiply(oprocentowanieDrugiProg)));
        } else {
            return df.format(kapitalPoczatkowy.add(kapitalPoczatkowy.multiply(oprocentowanieTrzeciProg)));
        }

    }

}
