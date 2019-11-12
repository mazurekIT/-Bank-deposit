package pl.mazurekit.provider;

import org.junit.jupiter.api.Test;
import pl.mazurekit.Range;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.mazurekit.RangeHelper.aRange;

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
        Range firstRange = aRange(0, 10000, 2);
        Range secondRange = aRange(10000, 20000, 4);
        Range thirdRange = aRange(20000, 30000, 6);

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