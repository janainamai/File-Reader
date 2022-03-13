package file.reader.service.extractor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RecordExtractTest {

    @Test
    void testExtractRecordFromLineIfExistMoreThanOne_whenExistsMoreThanOne() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99");

        List<String> records = RecordExtract.extractRecordFromLineIfExistMoreThanOne(lines, " ");

        List<String> extractedRecords = new ArrayList<>();
        extractedRecords.add("001ç1234567891234çDiegoç50000");
        extractedRecords.add("001ç3245678865434çRenatoç40000.99");

        Assertions.assertThat(records).containsAll(extractedRecords);
    }

    @Test
    void testExtractRecordFromLineIfExistMoreThanOne_whenNotExistsMoreThanOne() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");

        List<String> records = RecordExtract.extractRecordFromLineIfExistMoreThanOne(lines, " ");

        Assertions.assertThat(records).contains("001ç1234567891234çDiegoç50000");
    }

    @Test
    void testGetRecordsOfCode_whenFound() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");

        List<String> records = RecordExtract.getRecordsOfCode(lines, "002");
        Assertions.assertThat(records).contains("002ç2345675434544345çJose da SilvaçRural");
        Assertions.assertThat(records.size()).isEqualTo(1);
    }

}