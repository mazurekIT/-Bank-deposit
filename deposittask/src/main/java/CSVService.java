import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class CSVService implements ICSVService {

    private String filePath;
    private Map<BigDecimal, BigDecimal> ranges = new TreeMap<>();

    public CSVService(String filePath) {
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
                String interestString = csvRecord.get("oprocentowanie");
                BigDecimal interest = new BigDecimal(interestString
                        .replaceAll(" ", "")
                        .replaceAll(",", "."));

                this.addRange(rangeFrom, interest.divide(new BigDecimal(100)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRangeToCSV(Long rangeFrom, Long rangeTo, Long interest) {
        //TODO implementation of this function
    }

    public void addRange(BigDecimal range, BigDecimal interest) {
        ranges.put(range, interest);
    }

    public String getFilePath() {
        return filePath;
    }

    public Map<BigDecimal, BigDecimal> getRanges() {
        return ranges;
    }
}
