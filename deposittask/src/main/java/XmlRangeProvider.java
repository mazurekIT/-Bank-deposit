import java.util.List;

public class XmlRangeProvider implements RangeProvider{
    private String filePath;
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";

    public XmlRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    public XmlRangeProvider() {
    }

    @Override
    public List<Range> getAvailableRanges() {
        return null;
    }
}
