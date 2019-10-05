import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
class RangeFinderTest {

    @Mock
    RangeProvider rangeProvider;

    @InjectMocks
    RangeFinder rangeFinder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        List<Range> rangeList = new ArrayList<>();
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        rangeList.add(firstRange);
        rangeList.add(secondRange);
        Mockito.when(rangeProvider.getAvailableRanges()).thenReturn(rangeList);
    }

    @Test
    public void shouldFindRangeList() {
        List<Range> availableRanges = rangeProvider.getAvailableRanges();
        assertEquals(2, availableRanges.size());
    }

    @Test
    public void shouldFindFirstRange() {
        Range firstRange = new Range(new BigDecimal(0), new BigDecimal(10000), new BigDecimal(2));
        Optional<Range> properRangeForCapital = rangeFinder.findProperRangeForCapital(new BigDecimal(10000));
        assertEquals(firstRange, properRangeForCapital.get());
    }


    @Test
    public void shouldFindSecondRange() {
        Range secondRange = new Range(new BigDecimal(10000), new BigDecimal(20000), new BigDecimal(4));
        Optional<Range> properRangeForCapital = rangeFinder.findProperRangeForCapital(new BigDecimal(11000));
        assertEquals(secondRange, properRangeForCapital.get());
    }
}