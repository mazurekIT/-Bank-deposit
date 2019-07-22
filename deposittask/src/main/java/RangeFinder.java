import java.math.BigDecimal;

public class RangeFinder {
    private CSVReader csvReader;

    public RangeFinder(String filePath) {
        //TODO zabezpieczenie czy plik istnieje
        this.csvReader = new CSVReader(filePath);
    }

    public Range findProperRangeForCapital(BigDecimal startCapital) {
        Range range = new Range();
        for (Range csvrange : csvReader.getRangesList()) {
            if (isMoreThanMinRange(startCapital, csvrange.getMinCapital()) && isLessThanOrEqualsMaxRange(startCapital, csvrange.getMaxCapital())) {
                return csvrange;
            }
        }
        return range;
    }

    private boolean isMoreThanMinRange(BigDecimal capital, BigDecimal range) {
        return capital.compareTo(range) == 1;
    }

    private boolean isLessThanOrEqualsMaxRange(BigDecimal capital, BigDecimal range) {

        return capital.compareTo(range) <= 0;
    }

}
