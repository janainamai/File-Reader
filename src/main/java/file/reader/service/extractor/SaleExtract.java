package file.reader.service.extractor;

import file.reader.entities.Sale;

import java.util.List;

import static java.util.Arrays.stream;

// 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
// 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato
public class SaleExtract {

    private static final int id = 1;
    private static final int itemLine = 2;
    private static final int salesmanName = 3;

    public static List<Sale> extract(List<String> linesOfSale) {
        return linesOfSale.stream()
                .map(SaleExtract::extractToSale)
                .toList();
    }

    private static Sale extractToSale(String saleLine) {
        List<String> partsOfSale = stream(saleLine.split("ç")).toList();

        Sale sale = new Sale();
        sale.setId(partsOfSale.get(id));
        sale.setItems(ItemExtract.extract(partsOfSale.get(itemLine)));
        sale.setSalesmanName(partsOfSale.get(salesmanName));

        return sale;
    }

}
