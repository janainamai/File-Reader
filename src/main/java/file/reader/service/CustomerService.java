package file.reader.service;

import file.reader.entities.Customer;
import file.reader.service.extractor.CustomerExtract;
import file.reader.service.extractor.RecordExtract;

import java.util.List;

public class CustomerService {

    private static final String CUSTOMER_CODE = "002";

    public List<Customer> extractToCustomerEntities(List<String> records) {
        List<String> linesOfCustomer = RecordExtract.getRecordsOfCode(records, CUSTOMER_CODE);
        return CustomerExtract.extractToEntities(linesOfCustomer);
    }
}
