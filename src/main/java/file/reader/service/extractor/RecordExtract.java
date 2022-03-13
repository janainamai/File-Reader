package file.reader.service.extractor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class RecordExtract {

    private static final String CURRENT_SEPARATOR_OF_RECORDS = " ";
    private static final String CODE_OF_RECORDS_STARTS_WITH = "00";
    private static final String SEPARATOR = CURRENT_SEPARATOR_OF_RECORDS + CODE_OF_RECORDS_STARTS_WITH;

    public static List<String> extractRecordFromLineIfExistMoreThanOne(List<String> lines, String separator) {
        List<String> records = new ArrayList<>();

        lines.forEach(line -> {
            if (hasMoreThanOneRecord(line)) {
                List<String> record = extractRecordsFromLine(line, separator);
                records.addAll(record);
            } else {
                records.add(line);
            }
        });
        return records;
    }

    public static List<String> getRecordsOfCode(List<String> records, String code) {
        return records.stream()
                .filter(rec -> rec.startsWith(code))
                .toList();
    }

    private static boolean hasMoreThanOneRecord(String line) {
        int indexSeparator = line.indexOf(SEPARATOR);
        return indexSeparator != -1;
    }

    private static List<String> extractRecordsFromLine(String line, String separator) {
        String lineWithSeparator = insertSeparatorBetweenRecords(line, separator);
        return stream(lineWithSeparator.split(separator)).toList();
    }

    private static String insertSeparatorBetweenRecords(String line, String separator) {
        return line.replace(SEPARATOR, separator + CODE_OF_RECORDS_STARTS_WITH);
    }

}
