import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        Yaml yaml = new Yaml();
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            LinkedHashMap<String,ArrayList<LinkedHashMap<String,Number>>> load = yaml.load(fileInputStream);
            ArrayList<LinkedHashMap<String,Number>> rangeList = load.get("ranges");
            for (LinkedHashMap<String,Number> r:rangeList){
                Number rangeFrom = r.get(UNIT_NAME_FOR_RANGE_FROM);
                Number rangeTo = r.get(UNIT_NAME_FOR_RANGE_TO);
                Number interest = r.get(UNIT_NAME_FOR_INTEREST);
                obj.add(new Range(
                        convertDoubleToBigDecimal(rangeFrom),
                        convertDoubleToBigDecimal(rangeTo),
                        convertDoubleToBigDecimal(interest)
                ));
            }

            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private BigDecimal convertDoubleToBigDecimal(Number number){
        return new BigDecimal(number.doubleValue());
    }
}
