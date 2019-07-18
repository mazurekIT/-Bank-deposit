import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Capital capital = new Capital(new BigDecimal(50000));

        InvestmentCalculator investmentCalculator = new InvestmentCalculator();

        System.out.println(investmentCalculator.calculateOneYearProfit(capital.getValue()));

    }
}
