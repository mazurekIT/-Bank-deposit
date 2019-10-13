import java.math.BigDecimal;

public class Main {

    public static void main(String[] args)  {

        Capital capital = new Capital(new BigDecimal(40000));

        RangeProvider rangeProvider = new CsvRangeProvider("progi.csv");

        RangeFinder rangeFinder = new RangeFinder(rangeProvider);

        InvestmentCalculator investmentCalculator = new InvestmentCalculator(rangeFinder);

        System.out.println(investmentCalculator.calculateOneYearProfit(capital.getValue()));

    }
}
