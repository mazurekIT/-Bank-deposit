import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMinCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(new BigDecimal(-10),new BigDecimal(10),new BigDecimal(2));
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMaxCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(new BigDecimal(10),new BigDecimal(-10),new BigDecimal(2));
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMaxCapitalIsEqualsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(new BigDecimal(10),BigDecimal.ZERO,new BigDecimal(2));
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenInterestIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Range(new BigDecimal(10),new BigDecimal(10),new BigDecimal(-0.01));
        });
    }


}