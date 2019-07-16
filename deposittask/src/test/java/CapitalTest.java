import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CapitalTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Capital(new BigDecimal(-10));
        });
    }

}