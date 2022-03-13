package file.reader.service;

import file.reader.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomerServiceTest {

    @Test
    void testExtractToCustomerEntities() {
        CustomerService service = new CustomerService();

        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("001ç3245678865434çRenatoç40000.99");
        lines.add("002ç2345675433444345çEduardoPereiraçRural");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

        List<Customer> customers = service.extractToCustomerEntities(lines);
        Assertions.assertThat(customers.size()).isEqualTo(2);

        Customer customerEduardo = new Customer();
        customerEduardo.setCnpj("2345675433444345");
        customerEduardo.setName("EduardoPereira");
        customerEduardo.setBusinessArea("Rural");

        Customer customerJose = new Customer();
        customerJose.setCnpj("2345675434544345");
        customerJose.setName("Jose da Silva");
        customerJose.setBusinessArea("Rural");

        Assertions.assertThat(customers).contains(customerEduardo);
        Assertions.assertThat(customers).contains(customerJose);
    }

}