package file.reader.service.extractor;

import file.reader.entities.Item;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class ItemExtract {

    private static final int ID = 0;
    private static final int QUANTITY = 1;
    private static final int PRICE = 2;

    public static List<Item> extractToEntities(String lineOfItems) {
        lineOfItems = removeKeys(lineOfItems);
        List<String> linesOfItem = extractToLinesOfItem(lineOfItems);

        return linesOfItem.stream()
                .map(ItemExtract::extractToItem)
                .toList();
    }

    private static String removeKeys(String line) {
        return line.substring(1, line.length() - 1);
    }

    private static List<String> extractToLinesOfItem(String lineOfItems) {
        return stream(lineOfItems.split(",")).toList();
    }

    private static Item extractToItem(String itemLine) {
        List<String> partsOfItem = stream(itemLine.split("-")).toList();

        Item item = new Item();
        item.setId(partsOfItem.get(ID));
        item.setQuantity(parseInt(partsOfItem.get(QUANTITY)));
        item.setPrice(BigDecimal.valueOf(parseDouble(partsOfItem.get(PRICE))));

        return item;
    }

}
