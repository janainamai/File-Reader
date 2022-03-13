package file.reader.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class FileReaderUtilsTest {

    @Test
    void testGetKeyByValue_returnsKeyMatchesReceivedValue_whenFindOne() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("blue", 0);
        map.put("yellow", 1);
        map.put("red", 2);

        Assertions.assertThat(FileReaderUtils.getKeyByValue(map, 2)).isEqualTo("red");
    }

    @Test
    void testGetKeyByValue_throwException_whenNotFindOne() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("green", 0);
        map.put("grey", 1);
        Assertions.assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> FileReaderUtils.getKeyByValue(map, 2))
                .withMessage("No key found for value 2");
    }

}