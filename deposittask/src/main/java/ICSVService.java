public interface ICSVService {

    void readRangesFromCSV();
    void saveRangeToCSV(Long rangeFrom, Long rangeTo, Long interest);
}
