package file.reader.utils;

import java.util.Map;
import java.util.Optional;

public class FileReaderUtils {

    public static <T, X> T getKeyByValue(Map<T, X> map, X value) throws Exception {
        Optional<T> optional = map.entrySet()
                .stream()
                .filter(sale -> sale.getValue().equals(value))
                .findFirst()
                .map(Map.Entry::getKey);

        if(optional.isEmpty()) {
            throw new Exception("No key found for value " + value.toString());
        }
        return optional.get();
    }

}
