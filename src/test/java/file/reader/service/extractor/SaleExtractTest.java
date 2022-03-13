package file.reader.service.extractor;

import file.reader.entities.Sale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SaleExtractTest {

    @Test
    void testExtractToEntities_returnsSale() {
        List<String> lines = new ArrayList<>();
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

        List<Sale> sales = SaleExtract.extractToEntities(lines);
        Assertions.assertThat(sales.size()).isEqualTo(2);

        Sale sale = sales.get(0);
        Assertions.assertThat(sale.getId()).isEqualTo("10");
        Assertions.assertThat(sale.getItems().size()).isEqualTo(3);
        Assertions.assertThat(sale.getSalesmanName()).isEqualTo("Diego");
    }

}