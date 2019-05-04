import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world");

        Investment investment = new Investment();
        investment.addRange(BigDecimal.ZERO, new BigDecimal(0.02));
        investment.addRange(new BigDecimal(50000), new BigDecimal(0.03));
        investment.addRange(new BigDecimal(20000), new BigDecimal(0.025));
        investment.addRange(new BigDecimal(100000), new BigDecimal(0.035));

        System.out.println(investment.calculateOneYearProfit(new BigDecimal(200000)));


    }
}
