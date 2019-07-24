import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Capital capital = new Capital(new BigDecimal(50000));

        RangeFinder rangeFinder = new RangeFinder("progi.csv");

        InvestmentCalculator investmentCalculator = new InvestmentCalculator(rangeFinder);

        System.out.println(investmentCalculator.calculateOneYearProfit(capital.getValue()));

    }
}
