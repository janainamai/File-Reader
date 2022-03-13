package file.reader.service.extractor;

import file.reader.entities.Customer;

import java.util.List;

import static java.util.Arrays.stream;

public class CustomerExtract {

    private static final int CNPJ = 1;
    private static final int NAME = 2;
    private static final int BUSSINES_AREA = 3;

    public static List<Customer> extractToEntities(List<String> linesOfCustomer) {
        return linesOfCustomer.stream()
                .map(CustomerExtract::extractToCustomer)
                .toList();
    }

    private static Customer extractToCustomer(String customerLine) {
        List<String> partsOfCustomer = stream(customerLine.split("ç")).toList();

        Customer customer = new Customer();
        customer.setCnpj(partsOfCustomer.get(CNPJ));
        customer.setName(partsOfCustomer.get(NAME));
        customer.setBusinessArea(partsOfCustomer.get(BUSSINES_AREA));

        return customer;
    }

}
