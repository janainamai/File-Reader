package file.reader.service.extractor;

import file.reader.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomerExtractTest {

    @Test
    void testExtractToEntities_returnsCustomer() {
        List<String> lines = new ArrayList<>();
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("002ç2345675433444345çEduardoPereiraçRural");

        List<Customer> customers = CustomerExtract.extractToEntities(lines);
        Assertions.assertThat(customers.size()).isEqualTo(2);

        Customer customer = customers.get(0);
        Assertions.assertThat(customer.getCnpj()).isEqualTo("2345675434544345");
        Assertions.assertThat(customer.getName()).isEqualTo("Jose da Silva");
        Assertions.assertThat(customer.getBusinessArea()).isEqualTo("Rural");
    }

}