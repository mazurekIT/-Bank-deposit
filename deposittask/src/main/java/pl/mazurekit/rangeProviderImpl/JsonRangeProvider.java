package pl.mazurekit.rangeProviderImpl;

import pl.mazurekit.Range;
import pl.mazurekit.RangeProvider;
import pl.mazurekit.RangesReadException;
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
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";

    public JsonRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Range> getAvailableRanges() {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(filePath);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray jsonRanges = (JSONArray) jsonObject.get("ranges");

            List<Range> ranges = new ArrayList<>();

            Iterator<JSONObject> iterator = jsonRanges.iterator();
            while (iterator.hasNext()) {
                JSONObject range = iterator.next();
                BigDecimal capitalFrom = new BigDecimal((double) range.get(UNIT_NAME_FOR_RANGE_FROM));
                BigDecimal capitalTo = new BigDecimal((double) range.get(UNIT_NAME_FOR_RANGE_TO));
                BigDecimal interest = new BigDecimal((long) range.get(UNIT_NAME_FOR_INTEREST));
                ranges.add(new Range(capitalFrom, capitalTo, interest));
            }
            return ranges;
        } catch (IOException e) {
            throw new RangesReadException("Błędna ścieżka pliku JSON", e);
        } catch (ParseException e) {
            throw new RangesReadException("Błąd parsowania w pliku JSON", e);
        }
    }
}
