package file.reader.service;

import file.reader.entities.Salesman;
import file.reader.service.extractor.RecordExtract;
import file.reader.service.extractor.SalesmanExtract;

import java.util.List;

public class SalesmanService {

    private static final String SALESMAN_CODE = "001";

    public List<Salesman> extractToSalesmanEntities(List<String> records) {
        List<String> linesOfSalesman = RecordExtract.getRecordsOfCode(records, SALESMAN_CODE);
        return SalesmanExtract.extractToEntities(linesOfSalesman);
    }



}
