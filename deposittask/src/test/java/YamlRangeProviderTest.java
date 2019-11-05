import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class YamlRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        YamlRangeProvider yamlRangeProvider = new YamlRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, yamlRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges(){
        YamlRangeProvider yamlRangeProvider = new YamlRangeProvider(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(4));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(8));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000), new BigDecimal(12));

        assertEquals(firstRange,getRangeFromList(yamlRangeProvider,0));
        assertEquals(secondRange,getRangeFromList(yamlRangeProvider,1));
        assertEquals(thirdRange,getRangeFromList(yamlRangeProvider,2));
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiYAMLTest.yaml").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(YamlRangeProvider yamlRangeProvider, int index) {
        return yamlRangeProvider.getAvailableRanges().get(index);
    }

}