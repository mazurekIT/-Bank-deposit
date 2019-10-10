import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvRangeProvider implements RangeProvider {

    private String filePath;
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";

    public CsvRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Range> getAvailableRanges() {
        List<Range> rangesList = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withDelimiter('|')
                    .withIgnoreSurroundingSpaces(true)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            for (CSVRecord csvRecord : csvParser) {

                BigDecimal rangeFrom = readFromUnit(csvRecord, UNIT_NAME_FOR_RANGE_FROM);
                BigDecimal rangeTo = readFromUnit(csvRecord, UNIT_NAME_FOR_RANGE_TO);
                BigDecimal interest = readFromUnit(csvRecord, UNIT_NAME_FOR_INTEREST);

                rangesList.add(new Range(rangeFrom, rangeTo, interest));
            }


        } catch (IOException e) {
            throw new RangesReadException("Błędna ścieżka pliku", e);
        }
        return rangesList;


    }

    private BigDecimal readFromUnit(CSVRecord record, String unit) {
        return new BigDecimal(record.get(unit)
                .replaceAll(" ", "")
                .replaceAll(",00", "")
                .replaceAll(",", "."));
    }


}
