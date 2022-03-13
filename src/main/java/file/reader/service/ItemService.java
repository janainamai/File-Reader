package file.reader.service;

import file.reader.entities.Item;
import file.reader.service.extractor.ItemExtract;

import java.util.List;

public class ItemService {

    public List<Item> extractToItemEntities(String lineOfItems) {
        return ItemExtract.extract(lineOfItems);
    }
}
