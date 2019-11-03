import java.math.BigDecimal;


public class Main {

    public static void main(String[] args)  {

        Capital capital = new Capital(new BigDecimal(40000));

        RangeProvider csvRangeProvider = new CsvRangeProvider("progiCsv.csv");
        RangeFinder csvRangeFinder = new RangeFinder(csvRangeProvider);
        InvestmentCalculator csvInvestmentCalculator = new InvestmentCalculator(csvRangeFinder);
        System.out.println(csvInvestmentCalculator.calculateOneYearProfit(capital.getValue()));

        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider("progiJson.json");
        RangeFinder jsonRangeFinder = new RangeFinder(jsonRangeProvider);
        InvestmentCalculator jsonInvestmentCalculatorJson = new InvestmentCalculator(jsonRangeFinder);
        System.out.println(jsonInvestmentCalculatorJson.calculateOneYearProfit(capital.getValue()));

        YamlRangeProvider yamlRangeProvider = new YamlRangeProvider("progiYaml.yaml");
        RangeFinder yamlRangeFinder= new RangeFinder(yamlRangeProvider);
        InvestmentCalculator yamlInvestmentCalculator = new InvestmentCalculator(yamlRangeFinder);
        System.out.println(yamlInvestmentCalculator.calculateOneYearProfit(capital.getValue()));


        XmlRangeProvider xmlRangeProvider = new XmlRangeProvider("progiXml.xml");
        RangeFinder xmlRangeFinder= new RangeFinder(xmlRangeProvider);
        InvestmentCalculator xmlInvestmentCalculator = new InvestmentCalculator(xmlRangeFinder);
        System.out.println(xmlInvestmentCalculator.calculateOneYearProfit(capital.getValue()));
    }
}
