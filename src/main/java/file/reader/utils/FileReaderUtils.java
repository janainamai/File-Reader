package file.reader.utils;

import java.math.BigDecimal;
import java.util.Map;

public class FileReaderUtils {

    public static <T> T getKeyByValue(Map<T, BigDecimal> map, BigDecimal value) {
        return map.entrySet()
                .stream()
                .filter(sale -> sale.getValue().equals(value))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

}
