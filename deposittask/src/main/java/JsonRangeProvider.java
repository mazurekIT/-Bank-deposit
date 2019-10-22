import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class JsonRangeProvider implements RangeProvider {
    private String filePath;

    public JsonRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Range> getAvailableRanges() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(filePath);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray jsonRanges = (JSONArray) jsonObject.get("ranges");

            List<Range> ranges = new ArrayList<>();

            Iterator<JSONObject> iterator = jsonRanges.iterator();
            while (iterator.hasNext()) {
                JSONObject range = (JSONObject) iterator.next();
                BigDecimal capitalFrom = new BigDecimal((double) range.get("kwota_od"));
                BigDecimal capitalTo = new BigDecimal((double) range.get("kwota_do"));
                BigDecimal interest = new BigDecimal((long) range.get("oprocentowanie"));
                ranges.add(new Range(capitalFrom, capitalTo, interest));
            }
            return ranges;
        } catch (IOException e) {
            throw new RangesReadException("Błędna ścieżka pliku JSON", e);
        } catch (ParseException e) {
            System.out.println("Błąd parsowania");
            throw new RangesReadException("błąd parsowania", e);
        }
    }


    private static void parseRangeObject(JSONObject range) {
        JSONObject rangeObject = (JSONObject) range.get("kwota_od");
    }
}
