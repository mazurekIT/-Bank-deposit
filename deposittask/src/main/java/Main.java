import java.math.BigDecimal;


public class Main {

    public static void main(String[] args)  {

        Capital capital = new Capital(new BigDecimal(40000));

        RangeProvider csvRangeProvider = new CsvRangeProvider("progi.csv");
        RangeFinder csvRangeFinder = new RangeFinder(csvRangeProvider);
        InvestmentCalculator csvInvestmentCalculator = new InvestmentCalculator(csvRangeFinder);
        System.out.println(csvInvestmentCalculator.calculateOneYearProfit(capital.getValue()));

        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider("progi_json.json");
        RangeFinder jsonRangeFinder = new RangeFinder(jsonRangeProvider);
        InvestmentCalculator jsonInvestmentCalculatorJson = new InvestmentCalculator(jsonRangeFinder);
        System.out.println(jsonInvestmentCalculatorJson.calculateOneYearProfit(capital.getValue()));

    }
}
