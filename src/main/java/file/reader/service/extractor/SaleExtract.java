package file.reader.service.extractor;

import file.reader.entities.Sale;

import java.util.List;

import static java.util.Arrays.stream;

public class SaleExtract {

    private static final int ID = 1;
    private static final int ITEM_LINE = 2;
    private static final int SALESMAN_NAME = 3;

    public static List<Sale> extractToEntities(List<String> linesOfSale) {
        return linesOfSale.stream()
                .map(SaleExtract::extractToSale)
                .toList();
    }

    private static Sale extractToSale(String saleLine) {
        List<String> partsOfSale = stream(saleLine.split("ç")).toList();

        Sale sale = new Sale();
        sale.setId(partsOfSale.get(ID));
        sale.setItems(ItemExtract.extractToEntities(partsOfSale.get(ITEM_LINE)));
        sale.setSalesmanName(partsOfSale.get(SALESMAN_NAME));

        return sale;
    }

}
