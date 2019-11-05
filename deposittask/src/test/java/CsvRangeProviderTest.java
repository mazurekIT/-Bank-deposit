import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        CsvRangeProvider csvRangeProvider = new CsvRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, csvRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges() {
        CsvRangeProvider csvRangeProvider = new CsvRangeProvider(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000.00), new BigDecimal(6));

        assertEquals(firstRange, getRangeFromList(csvRangeProvider, 0));
        assertEquals(secondRange, getRangeFromList(csvRangeProvider, 1));
        assertEquals(thirdRange, getRangeFromList(csvRangeProvider, 2));
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiCSVTest.csv").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(CsvRangeProvider csvRangeProvider, int index) {
        return csvRangeProvider.getAvailableRanges().get(index);
    }

}