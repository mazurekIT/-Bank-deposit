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

    private static final String CSV_FILE_PATH = "progi.csv";

    private Map<BigDecimal, BigDecimal> ranges = new TreeMap<>();


    public Investment() {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withDelimiter(',')
                    .withRecordSeparator("|")
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
            for (CSVRecord csvRecord : csvParser) {
//                String kwotaOd = csvRecord.get("kwota_od ");
//                String kwotaDo = csvRecord.get("kwota_do");
//                String oprocentowanie = csvRecord.get("oprocentowanie");

//                System.out.println(kwotaOd + "#" + kwotaDo + "#" + oprocentowanie);
                System.out.println(csvRecord.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addRange(BigDecimal.ZERO, new BigDecimal(0.02));
        this.addRange(new BigDecimal(50000), new BigDecimal(0.03));
        this.addRange(new BigDecimal(20000), new BigDecimal(0.025));


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
        if (startCapital.compareTo(BigDecimal.ZERO) < 0) {
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
