import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonRangeProviderTest {

    @Test
    public void shouldCheckSizeOfRangesList() {
        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider(filePath());
        int expectedSizeOfRanges = 3;
        assertEquals(expectedSizeOfRanges, jsonRangeProvider.getAvailableRanges().size());
    }

    @Test
    public void shouldReadProperlyAllRanges() {
        JsonRangeProvider jsonRangeProvider = new JsonRangeProvider(filePath());
        Range firstRange = RangeHelper.aRange(0, 10000, 3);
        Range secondRange = RangeHelper.aRange(10000, 20000, 6);
        Range thirdRange = RangeHelper.aRange(20000, 30000, 9);

        assertEquals(firstRange, getRangeFromList(jsonRangeProvider, 0));
        assertEquals(secondRange, getRangeFromList(jsonRangeProvider, 1));
        assertEquals(thirdRange, getRangeFromList(jsonRangeProvider, 2));
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