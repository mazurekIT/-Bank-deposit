import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Investment {
    DecimalFormat df = new DecimalFormat("#.00");

    private static final String filePath = "progi.csv";

    private Map<BigDecimal, BigDecimal> ranges = new TreeMap<>();


    public Investment() {

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
                .replaceAll(" ","")
                .replaceAll(",","."));

                this.addRange(rangeFrom, interest.divide(new BigDecimal(100)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addRange(BigDecimal range, BigDecimal interest) {
        ranges.put(range, interest);
    }

    private BigDecimal findValueForKey(BigDecimal key) {
        ranges.putIfAbsent(key, BigDecimal.ZERO);
        return ranges.get(key);
    }

    private BigDecimal findRangeOfStartCapital(BigDecimal startCapital) {
        BigDecimal lowerRange = BigDecimal.ZERO;
        if (startCapital.compareTo(lowerRange) < 0) {
            throw new IllegalArgumentException();
        }
        for (BigDecimal x : ranges.keySet()) {
            if (startCapital.compareTo(x) > 0) {
                lowerRange = x;
            }
        }
        return lowerRange;
    }

    public String calculateOneYearProfit(BigDecimal startCapital) {
        BigDecimal interest = findValueForKey(findRangeOfStartCapital(startCapital));

        return df.format(startCapital.multiply(BigDecimal.ONE.add(interest)));
    }


    public Map<BigDecimal, BigDecimal> getRanges() {
        return ranges;
    }
}
