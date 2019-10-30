import java.util.List;

public class RangeList {
    public List<Range> ranges;

    public RangeList(List<Range> ranges) {
        this.ranges = ranges;
    }

    public RangeList() {
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(List<Range> ranges) {
        this.ranges = ranges;
    }
}
