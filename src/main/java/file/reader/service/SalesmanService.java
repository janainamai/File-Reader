package file.reader.service;

import file.reader.entities.Salesman;
import file.reader.service.extractor.RecordExtract;
import file.reader.service.extractor.SalesmanExtract;
import file.reader.utils.FileReaderUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesmanService {

    private static final String salesmanCode = "001";

    public List<Salesman> extractToSalesmanEntities(List<String> records) {
        List<String> linesOfSalesman = RecordExtract.getRecordsOfCode(records, salesmanCode);
        return SalesmanExtract.extract(linesOfSalesman);
    }



}
