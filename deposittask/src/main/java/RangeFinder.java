import java.math.BigDecimal;

public class RangeFinder {
    private CSVReader csvReader = new CSVReader("progi.csv");

    public Range findProperRangeForCapital(BigDecimal startCapital) {
        Range range = new Range();
        for (Range csvrange : csvReader.getRangesList()) {
            if (startCapital.compareTo(csvrange.getMinCapital()) == 1 && startCapital.compareTo(csvrange.getMaxCapital()) <= 0) {
                return csvrange;
            }
        }
        return range;
    }

}
