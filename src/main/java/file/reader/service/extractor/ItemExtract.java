package file.reader.service.extractor;

import file.reader.entities.Item;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

// [Item ID-Item Quantity-Item Price]
// [1-34-10,2-33-1.50,3-40-0.10]
public class ItemExtract {

    private static final int id = 0;
    private static final int quantity = 1;
    private static final int price = 2;

    public static List<Item> extract(String lineOfItems) {
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
        item.setId(partsOfItem.get(id));
        item.setQuantity(parseInt(partsOfItem.get(quantity)));
        item.setPrice(BigDecimal.valueOf(parseDouble(partsOfItem.get(price))));

        return item;
    }

}
