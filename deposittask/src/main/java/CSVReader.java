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
    private final String unitNameForRangeFrom = "kwota_od";
    private final String unitNameForRangeTo = "kwota_do";
    private final String unitNameForInterest = "oprocentowanie";

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

                BigDecimal rangeFrom = readFromUnit(csvRecord, unitNameForRangeFrom);
                BigDecimal rangeTo = readFromUnit(csvRecord, unitNameForRangeTo);
                BigDecimal interest = readFromUnit(csvRecord, unitNameForInterest);

                rangesList.add(new Range(rangeFrom, rangeTo, interest.divide(new BigDecimal(100))));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private BigDecimal readFromUnit(CSVRecord record, String unit) {
        String rawString = record.get(unit);
        BigDecimal convertValue = new BigDecimal(rawString
                .replaceAll(" ", "")
                .replaceAll(",", "."));
        return convertValue;
    }


    public List<Range> getRangesList() {
        return rangesList;
    }

}
