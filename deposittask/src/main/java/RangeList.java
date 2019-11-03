import java.io.Serializable;

public class RangeList implements Serializable {
    private Range[] rangeList;

    public RangeList() {
        super();
    }

    public RangeList(Range[] rangeList) {
        this.rangeList = rangeList;
    }

    public Range[] getRangeList() {
        return rangeList;
    }

}
