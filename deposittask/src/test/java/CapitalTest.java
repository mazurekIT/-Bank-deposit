import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CapitalTest {

    @Test
    public void create(){
        final Capital capital = new Capital(new BigDecimal(10));
        BigDecimal bigDecimal = new BigDecimal(10);
        assertEquals(bigDecimal,capital.getValue());
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCapitalIsLowerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Capital(new BigDecimal(-10));
        });
    }

}