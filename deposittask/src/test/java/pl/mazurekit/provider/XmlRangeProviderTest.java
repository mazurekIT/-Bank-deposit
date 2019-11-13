package pl.mazurekit.provider;

import org.junit.jupiter.api.Test;
import pl.mazurekit.Range;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.mazurekit.RangeHelper.aRange;

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
        Range firstRange = aRange(0, 10000, 1);
        Range secondRange = aRange(10000, 20000, 2);
        Range thirdRange = aRange(20000, 30000, 3);

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

}