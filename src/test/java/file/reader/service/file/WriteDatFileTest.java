package file.reader.service.file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WriteDatFileTest {

    @Test
    void testCreateFileResult() throws Exception {
        WriteDatFile writer = new WriteDatFile();
        ReadDatFile reader = new ReadDatFile();

        List<String> lines = List.of("001ç1234567891234çDiegoç50000", "001ç3245678865434çRenatoç40000.99",
                "002ç2345675433444345çEduardoPereiraçRural", "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego",
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato", "002ç2345675434544345çJose da SilvaçRural");

        writer.createFileResult("test", lines);
        List<String> readLines = reader.read("test");
        Assertions.assertThat(readLines).containsAll(lines);
    }

}