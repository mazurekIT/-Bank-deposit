import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        XmlRangeProvider xmlRangeProvider = new XmlRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, xmlRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges() {
        XmlRangeProvider xmlRangeProvider = new XmlRangeProvider(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(1));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(2));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000), new BigDecimal(3));

        Range rangeFromList1 = getRangeFromList(xmlRangeProvider, 0);
        Range rangeFromList2 = getRangeFromList(xmlRangeProvider, 1);
        Range rangeFromList3 = getRangeFromList(xmlRangeProvider, 2);

        assertEquals(firstRange, rangeFromList1);
        assertEquals(secondRange, rangeFromList2);
        assertEquals(thirdRange, rangeFromList3);
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiXMLTest.xml").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(XmlRangeProvider xmlRangeProvider, int index) {
        return xmlRangeProvider.getAvailableRanges().get(index);
    }

}