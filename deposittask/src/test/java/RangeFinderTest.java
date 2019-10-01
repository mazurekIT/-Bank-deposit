import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RangeFinderTest {

    @Mock
    RangeProvider rangeProvider;

    RangeFinder rangeFinder;

    @BeforeEach
    public void setUp() {
        rangeFinder = new RangeFinder(rangeProvider);

        List<Range> rangeList = new ArrayList<>();
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        rangeList.add(firstRange);
        rangeList.add(secondRange);
        Mockito.when(rangeProvider.getAvailableRanges()).thenReturn(rangeList);
        rangeProvider.getAvailableRanges();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindRangeList() {
        List<Range> availableRanges = rangeProvider.getAvailableRanges();
        assertEquals(2, availableRanges.size());
    }

    @Test
    public void shouldFindFirstRange() {
        Optional<Range> properRangeForCapital = rangeFinder.findProperRangeForCapital(new BigDecimal(5000));
        assert (properRangeForCapital.isPresent());
    }


}