package pl.mazurekit;

import java.math.BigDecimal;

public class RangeHelper {

    public static Range aRange(int rangeFrom, int rangeTo, int interest) {
        return new Range(new BigDecimal(rangeFrom), new BigDecimal(rangeTo), new BigDecimal(interest));
    }
}
