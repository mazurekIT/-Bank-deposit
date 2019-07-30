import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CSVReaderTest {
    private static final DecimalFormat DF = new DecimalFormat("#0.00");


    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiTest.csv").getFile());
        return file.getAbsolutePath();
    }

    @Test
    public void shouldCheckSizeOfRangesList() {
        CSVReader csvReader = new CSVReader(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, csvReader.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges(){
        CSVReader csvReader = new CSVReader(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000.00), new BigDecimal(6));

        assertTrue(firstRange.equals(getRangeFromList(csvReader,0)));
        assertTrue(secondRange.equals(getRangeFromList(csvReader,1)));
        assertTrue(thirdRange.equals(getRangeFromList(csvReader,2)));

    }

    private Range getRangeFromList(CSVReader csvReader, int index) {
        return csvReader.getAvailableRanges().get(index);
    }

}