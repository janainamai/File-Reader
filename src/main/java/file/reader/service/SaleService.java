package file.reader.service;

import file.reader.entities.Sale;
import file.reader.service.extractor.RecordExtract;
import file.reader.service.extractor.SaleExtract;
import file.reader.utils.FileReaderUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleService {

    private static final String SALE_CODE = "003";

    public List<Sale> extractToSaleEntities(List<String> records) {
        List<String> linesOfSale = RecordExtract.getRecordsOfCode(records, SALE_CODE);
        return SaleExtract.extractToEntities(linesOfSale);
    }

    public Sale getMostExpansiveSale(List<Sale> sales) throws Exception {
        Map<Sale, BigDecimal> saleTotalPrice = agroupSaleWithTotalPrice(sales);
        return getMostExpansiveSale(saleTotalPrice);
    }

    public String getWorstSalesmanEver(List<Sale> sales) throws Exception {
        Map<String, BigDecimal> salesmanTotalPrice = agroupSalesmanWithTotalPrice(sales);

        return getSalesmanOfLeastExpansiveSale(salesmanTotalPrice);
    }

    private Map<Sale, BigDecimal> agroupSaleWithTotalPrice(List<Sale> sales) {
        Map<Sale, BigDecimal> saleTotalPrice = new HashMap<>();
        sales.forEach(sale -> {
            BigDecimal totalValueOfSale = getTotalSaleValue(sale);
            saleTotalPrice.put(sale, totalValueOfSale);
        });
        return saleTotalPrice;
    }

    private Map<String, BigDecimal> agroupSalesmanWithTotalPrice(List<Sale> sales) {
        Map<String, BigDecimal> salesmanTotalPrice = new HashMap<>();

        sales.forEach(sale -> {
            BigDecimal totalPriceOfSale = getTotalSaleValue(sale);

            if (salesmanTotalPrice.containsKey(sale.getSalesmanName())) {
                salesmanTotalPrice.get(sale.getSalesmanName()).add(totalPriceOfSale);
            } else {
                salesmanTotalPrice.put(sale.getSalesmanName(), totalPriceOfSale);
            }
        });

        return salesmanTotalPrice;
    }

    private BigDecimal getTotalSaleValue(Sale sale) {
        return sale.getItems().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Sale getMostExpansiveSale(Map<Sale, BigDecimal> saleTotalPrice) throws Exception {
        BigDecimal mostExpansiveValue = Collections.max(saleTotalPrice.values());
        return FileReaderUtils.getKeyByValue(saleTotalPrice, mostExpansiveValue);
    }

    private String getSalesmanOfLeastExpansiveSale(Map<String, BigDecimal> salesmanTotalPrice) throws Exception {
        BigDecimal lassExpansiveValue = Collections.min(salesmanTotalPrice.values());
        return FileReaderUtils.getKeyByValue(salesmanTotalPrice, lassExpansiveValue);
    }

}
