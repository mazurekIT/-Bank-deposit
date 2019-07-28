import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void shouldReadProperlyFirstRange() {
        CSVReader csvReader = new CSVReader(filePath());
        assertEquals(DF.format(BigDecimal.ZERO), DF.format(getRangeFromList(csvReader, 0).getMinCapital()));
        assertEquals(DF.format(new BigDecimal(10000)), DF.format(getRangeFromList(csvReader, 0).getMaxCapital()));
        assertEquals(DF.format(new BigDecimal(0.02)), DF.format(getRangeFromList(csvReader, 0).getInterest()));
    }

    @Test
    public void shouldReadProperlySecondRange() {
        CSVReader csvReader = new CSVReader(filePath());
        assertEquals(DF.format(new BigDecimal(10000)), DF.format(getRangeFromList(csvReader, 1).getMinCapital()));
        assertEquals(DF.format(new BigDecimal(20000)), DF.format(getRangeFromList(csvReader, 1).getMaxCapital()));
        assertEquals(DF.format(new BigDecimal(0.04)), DF.format(getRangeFromList(csvReader, 1).getInterest()));
    }

    @Test
    public void shouldReadProperlyThirdRange() {
        CSVReader csvReader = new CSVReader(filePath());
        assertEquals(DF.format(new BigDecimal(20000)), DF.format(getRangeFromList(csvReader, 2).getMinCapital()));
        assertEquals(DF.format(new BigDecimal(30000)), DF.format(getRangeFromList(csvReader, 2).getMaxCapital()));
        assertEquals(DF.format(new BigDecimal(0.06)), DF.format(getRangeFromList(csvReader, 2).getInterest()));
    }

    private Range getRangeFromList(CSVReader csvReader, int index) {
        return csvReader.getAvailableRanges().get(index);
    }

}