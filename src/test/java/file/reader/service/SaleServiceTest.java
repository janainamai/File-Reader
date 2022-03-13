package file.reader.service;

import file.reader.entities.Item;
import file.reader.entities.Sale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class SaleServiceTest {

    @Test
    void testExtractToSaleEntities() {
        SaleService service = new SaleService();

        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("001ç3245678865434çRenatoç40000.99");
        lines.add("002ç2345675433444345çEduardoPereiraçRural");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

        List<Sale> sales = service.extractToSaleEntities(lines);
        Assertions.assertThat(sales.size()).isEqualTo(2);

        Item item1sale10 = new Item();
        item1sale10.setId("1");
        item1sale10.setQuantity(10);
        item1sale10.setPrice(BigDecimal.valueOf(100.0));

        Item item2sale10 = new Item();
        item2sale10.setId("2");
        item2sale10.setQuantity(30);
        item2sale10.setPrice(BigDecimal.valueOf(2.5));

        Item item3sale10 = new Item();
        item3sale10.setId("3");
        item3sale10.setQuantity(40);
        item3sale10.setPrice(BigDecimal.valueOf(3.1));

        Sale sale10 = new Sale();
        sale10.setId("10");
        sale10.setItems(List.of(item1sale10, item2sale10, item3sale10));
        sale10.setSalesmanName("Diego");

        Item item1sale08 = new Item();
        item1sale08.setId("1");
        item1sale08.setQuantity(34);
        item1sale08.setPrice(BigDecimal.valueOf(10.0));

        Item item2sale08 = new Item();
        item2sale08.setId("2");
        item2sale08.setQuantity(33);
        item2sale08.setPrice(BigDecimal.valueOf(1.5));

        Item item3sale08 = new Item();
        item3sale08.setId("3");
        item3sale08.setQuantity(40);
        item3sale08.setPrice(BigDecimal.valueOf(0.1));

        Sale sale08 = new Sale();
        sale08.setId("08");
        sale08.setItems(List.of(item1sale08, item2sale08, item3sale08));
        sale08.setSalesmanName("Renato");

        Assertions.assertThat(sales).contains(sale10);
        Assertions.assertThat(sales).contains(sale08);
    }

    @Test
    void testGetMostExpansiveSale() throws Exception {
        SaleService service = new SaleService();

        Item item1sale10 = new Item();
        item1sale10.setId("1");
        item1sale10.setQuantity(10);
        item1sale10.setPrice(BigDecimal.valueOf(100.0));

        Item item2sale10 = new Item();
        item2sale10.setId("2");
        item2sale10.setQuantity(30);
        item2sale10.setPrice(BigDecimal.valueOf(2.5));

        Item item3sale10 = new Item();
        item3sale10.setId("3");
        item3sale10.setQuantity(40);
        item3sale10.setPrice(BigDecimal.valueOf(3.1));

        Sale sale10 = new Sale();
        sale10.setId("10");
        sale10.setItems(List.of(item1sale10, item2sale10, item3sale10));
        sale10.setSalesmanName("Diego");

        Item item1sale08 = new Item();
        item1sale08.setId("1");
        item1sale08.setQuantity(34);
        item1sale08.setPrice(BigDecimal.valueOf(10.0));

        Item item2sale08 = new Item();
        item2sale08.setId("2");
        item2sale08.setQuantity(33);
        item2sale08.setPrice(BigDecimal.valueOf(1.5));

        Item item3sale08 = new Item();
        item3sale08.setId("3");
        item3sale08.setQuantity(40);
        item3sale08.setPrice(BigDecimal.valueOf(0.1));

        Sale sale08 = new Sale();
        sale08.setId("08");
        sale08.setItems(List.of(item1sale08, item2sale08, item3sale08));
        sale08.setSalesmanName("Renato");

        List<Sale> sales = List.of(sale08, sale10);

        Assertions.assertThat(service.getMostExpansiveSale(sales)).isEqualTo(sale10);
    }

    @Test
    void testWorstSalesmanEver() throws Exception {
        SaleService service = new SaleService();

        Item item1sale10 = new Item();
        item1sale10.setId("1");
        item1sale10.setQuantity(10);
        item1sale10.setPrice(BigDecimal.valueOf(100.0));

        Item item2sale10 = new Item();
        item2sale10.setId("2");
        item2sale10.setQuantity(30);
        item2sale10.setPrice(BigDecimal.valueOf(2.5));

        Item item3sale10 = new Item();
        item3sale10.setId("3");
        item3sale10.setQuantity(40);
        item3sale10.setPrice(BigDecimal.valueOf(3.1));

        Sale sale10 = new Sale();
        sale10.setId("10");
        sale10.setItems(List.of(item1sale10, item2sale10, item3sale10));
        sale10.setSalesmanName("Diego");

        Item item1sale08 = new Item();
        item1sale08.setId("1");
        item1sale08.setQuantity(34);
        item1sale08.setPrice(BigDecimal.valueOf(10.0));

        Item item2sale08 = new Item();
        item2sale08.setId("2");
        item2sale08.setQuantity(33);
        item2sale08.setPrice(BigDecimal.valueOf(1.5));

        Item item3sale08 = new Item();
        item3sale08.setId("3");
        item3sale08.setQuantity(40);
        item3sale08.setPrice(BigDecimal.valueOf(0.1));

        Sale sale08 = new Sale();
        sale08.setId("08");
        sale08.setItems(List.of(item1sale08, item2sale08, item3sale08));
        sale08.setSalesmanName("Renato");

        List<Sale> sales = List.of(sale08, sale10);

        Assertions.assertThat(service.getWorstSalesmanEver(sales)).isEqualTo("Renato");
    }

}