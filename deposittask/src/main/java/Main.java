import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Capital capital = new Capital(new BigDecimal(50000));

        RangeProvider csvReader = new CSVReader("progi.csv");

        RangeFinder rangeFinder = new RangeFinder(csvReader);

        InvestmentCalculator investmentCalculator = new InvestmentCalculator(rangeFinder);

        System.out.println(investmentCalculator.calculateOneYearProfit(capital.getValue()));

    }
}
