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

public class CSVReader implements ICSVService {

    private String filePath;
    private List<Range> rangesList = new ArrayList<>();

    public CSVReader(String filePath) {
        this.filePath = filePath;
        this.readRangesFromCSV();
    }

    @Override
    public void readRangesFromCSV() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withDelimiter('|')
                    .withIgnoreSurroundingSpaces(true)
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            for (CSVRecord csvRecord : csvParser) {
                String rangeFromString = csvRecord.get("kwota_od");
                BigDecimal rangeFrom = new BigDecimal(rangeFromString
                        .replaceAll(" ", "")
                        .replaceAll(",", "."));

                String rangeToString = csvRecord.get("kwota_do");
                BigDecimal rangeTo = new BigDecimal(rangeToString
                        .replaceAll(" ", "")
                        .replaceAll(",", "."));

                String interestString = csvRecord.get("oprocentowanie");
                BigDecimal interest = new BigDecimal(interestString
                        .replaceAll(" ", "")
                        .replaceAll(",", "."));

                rangesList.add(new Range(rangeFrom,rangeTo,interest.divide(new BigDecimal(100))));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Range> getRangesList() {
        return rangesList;
    }

}
