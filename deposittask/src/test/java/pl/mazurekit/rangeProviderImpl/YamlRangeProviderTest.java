package pl.mazurekit.rangeProviderImpl;

import org.junit.jupiter.api.Test;
import pl.mazurekit.Range;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.mazurekit.RangeHelper.aRange;

class YamlRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        YamlRangeProvider yamlRangeProvider = new YamlRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, yamlRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges() {
        YamlRangeProvider yamlRangeProvider = new YamlRangeProvider(filePath());
        Range firstRange = aRange(0, 10000, 4);
        Range secondRange = aRange(10000, 20000, 8);
        Range thirdRange = aRange(20000, 30000, 12);

        assertEquals(firstRange, getRangeFromList(yamlRangeProvider, 0));
        assertEquals(secondRange, getRangeFromList(yamlRangeProvider, 1));
        assertEquals(thirdRange, getRangeFromList(yamlRangeProvider, 2));
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiYAMLTest.yaml").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(YamlRangeProvider yamlRangeProvider, int index) {
        return yamlRangeProvider.getAvailableRanges().get(index);
    }

    private Range createRange() {
        return new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(4));
    }

}