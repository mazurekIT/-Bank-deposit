import java.math.BigDecimal;
import java.util.Optional;

public class RangeFinder {
    private CSVReader csvReader;

    public RangeFinder(String filePath) {
        //TODO zabezpieczenie czy plik istnieje
        this.csvReader = new CSVReader(filePath);
    }


    public Optional<Range> findProperRangeForCapital(BigDecimal startCapital) {
        for (Range csvrange : csvReader.getRangesList()) {
            if (isMoreThanMinRange(startCapital, csvrange.getMinCapital()) && isLessThanOrEqualsMaxRange(startCapital, csvrange.getMaxCapital())) {
                return Optional.of(csvrange);
            }
        }
        return Optional.empty();
    }

    private boolean isMoreThanMinRange(BigDecimal capital, BigDecimal range) {
        return capital.compareTo(range) == 1;
    }

    private boolean isLessThanOrEqualsMaxRange(BigDecimal capital, BigDecimal range) {

        return capital.compareTo(range) <= 0;
    }

}
