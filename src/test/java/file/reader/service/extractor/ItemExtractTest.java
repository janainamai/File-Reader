package file.reader.service.extractor;

import file.reader.entities.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class ItemExtractTest {

    @Test
    void testExtractToEntities_returnsItem() {
        String lineOfItems = "[1-10-100,2-30-2.50,3-40-3.10]";

        List<Item> items = ItemExtract.extractToEntities(lineOfItems);
        Assertions.assertThat(items.size()).isEqualTo(3);

        Item customer = items.get(0);
        Assertions.assertThat(customer.getId()).isEqualTo("1");
        Assertions.assertThat(customer.getQuantity()).isEqualTo(10);
        Assertions.assertThat(customer.getPrice()).isEqualTo(BigDecimal.valueOf(100.0));
    }

}