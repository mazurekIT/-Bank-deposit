import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

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
        Range firstRange = RangeHelper.aRange(0, 10000, 1);
        Range secondRange = RangeHelper.aRange(10000, 20000, 2);
        Range thirdRange = RangeHelper.aRange(20000, 30000, 3);

        assertEquals(firstRange, getRangeFromList(xmlRangeProvider, 0));
        assertEquals(secondRange, getRangeFromList(xmlRangeProvider, 1));
        assertEquals(thirdRange, getRangeFromList(xmlRangeProvider, 2));
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiXMLTest.xml").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(XmlRangeProvider xmlRangeProvider, int index) {
        return xmlRangeProvider.getAvailableRanges().get(index);
    }

    private Range createRange(int a, int b, int c) {
        return new Range(new BigDecimal(a), new BigDecimal(b), new BigDecimal(c));
    }

}