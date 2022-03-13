package file.reader.service.extractor;

import file.reader.entities.Customer;

import java.util.List;

import static java.util.Arrays.stream;

// 002çCNPJçNameçBusiness Area
// 002ç2345675434544345çJose da SilvaçRural
public class CustomerExtract {

    private static final int cnpj = 1;
    private static final int name = 2;
    private static final int bussinesArea = 3;

    public static List<Customer> extract(List<String> linesOfCustomer) {
        return linesOfCustomer.stream()
                .map(CustomerExtract::extactToCustomer)
                .toList();
    }

    private static Customer extactToCustomer(String customerLine) {
        List<String> partsOfCustomer = stream(customerLine.split("ç")).toList();

        Customer customer = new Customer();
        customer.setCnpj(partsOfCustomer.get(cnpj));
        customer.setName(partsOfCustomer.get(name));
        customer.setBusinessArea(partsOfCustomer.get(bussinesArea));

        return customer;
    }

}
