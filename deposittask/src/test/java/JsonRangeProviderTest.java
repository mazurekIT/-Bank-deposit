import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class JsonRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, jsonRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges(){
        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider(filePath());
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(3));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(6));
        Range thirdRange = new Range(new BigDecimal(20000), new BigDecimal(30000), new BigDecimal(9));

        assertEquals(firstRange,getRangeFromList(jsonRangeProvider,0));
        assertEquals(secondRange,getRangeFromList(jsonRangeProvider,1));
        assertEquals(thirdRange,getRangeFromList(jsonRangeProvider,2));
    }

    private String filePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("progiJSONTest.json").getFile());
        return file.getAbsolutePath();
    }

    private Range getRangeFromList(JsonRangeProvider jsonRangeProvider, int index) {
        return jsonRangeProvider.getAvailableRanges().get(index);
    }
}