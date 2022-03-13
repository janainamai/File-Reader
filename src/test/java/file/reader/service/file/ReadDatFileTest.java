package file.reader.service.file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReadDatFileTest {

    @Test
    void testRead_readDatFiles() throws Exception {
        ReadDatFile readDatFile = new ReadDatFile();

        List<String> records = readDatFile.read("test");
        Assertions.assertThat(records).containsAll(List.of("001ç1234567891234çDiegoç50000", "001ç3245678865434çRenatoç40000.99",
                "002ç2345675433444345çEduardoPereiraçRural", "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego",
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato", "002ç2345675434544345çJose da SilvaçRural"));
    }

    @Test
    void testRead_readDatFiles_throwException() {
        ReadDatFile readDatFile = new ReadDatFile();

        Assertions.assertThatExceptionOfType(Exception.class).isThrownBy(() -> readDatFile.read("directory"));
    }

}