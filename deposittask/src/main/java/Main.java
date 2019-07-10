import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Capital capital = new Capital(new BigDecimal(30000));

        Investment investment = new Investment();

        System.out.println(investment.calculateOneYearProfit(capital.getCapitalValue()));

    }
}
