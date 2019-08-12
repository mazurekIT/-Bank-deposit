import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvRangeProviderTest {


    @Test
    public void shouldCheckSizeOfRangesList() {
        CsvRangeProvider csvRangeProvider = new CsvRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, csvRangeProvider.getAvailableRanges().size());
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiTest.csv").getFile());
        return file.getAbsolutePath();
    }

    @Test
    public void shouldReadProperlyAllRanges() {
        CsvRangeProvider csvRangeProvider = new CsvRangeProvider(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000.00), new BigDecimal(6));

        assertTrue(firstRange.equals(getRangeFromList(csvRangeProvider, 0)));
        assertTrue(secondRange.equals(getRangeFromList(csvRangeProvider, 1)));
        assertTrue(thirdRange.equals(getRangeFromList(csvRangeProvider, 2)));
    }

    private Range getRangeFromList(CsvRangeProvider csvRangeProvider, int index) {
        return csvRangeProvider.getAvailableRanges().get(index);
    }

}