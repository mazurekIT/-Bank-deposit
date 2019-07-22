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

public class CSVReader implements FileReaderService {

    private String filePath;
    private List<Range> rangesList = new ArrayList<>();
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";

    public CSVReader(String filePath) {
        this.filePath = filePath;
        this.readRangesFromFile();
    }

    @Override
    public void readRangesFromFile() {
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

                rangesList.add(new Range(rangeFrom, rangeTo, interest.divide(new BigDecimal(100))));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private BigDecimal readFromUnit(CSVRecord record, String unit) {
        return new BigDecimal(record.get(unit)
                .replaceAll(" ", "")
                .replaceAll(",", "."));
    }


    public List<Range> getRangesList() {
        return rangesList;
    }

}
