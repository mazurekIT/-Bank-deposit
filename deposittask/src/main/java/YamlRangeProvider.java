import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YamlRangeProvider implements RangeProvider {
    private String filePath;
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";


    public YamlRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Range> getAvailableRanges() {
        List<Range> obj = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        try {
            RangeList rangeList = objectMapper.readValue(new File(filePath),RangeList.class);
        } catch (IOException e) {
            System.out.println("eeeeeeeeeeeeeeeeeee");
        }

        return obj;
    }
}
