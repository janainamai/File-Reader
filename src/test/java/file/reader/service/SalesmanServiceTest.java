package file.reader.service;

import file.reader.entities.Salesman;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class SalesmanServiceTest {

    @Test
    void testExtractToSalesmanEntities() {
        SalesmanService service = new SalesmanService();

        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("001ç3245678865434çRenatoç40000.99");
        lines.add("002ç2345675433444345çEduardoPereiraçRural");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

        List<Salesman> salesmans = service.extractToSalesmanEntities(lines);

        Salesman salesmanDiego = new Salesman();
        salesmanDiego.setCpf("1234567891234");
        salesmanDiego.setName("Diego");
        salesmanDiego.setSalary(BigDecimal.valueOf(50000.0));

        Salesman salesmanRenato = new Salesman();
        salesmanRenato.setCpf("3245678865434");
        salesmanRenato.setName("Renato");
        salesmanRenato.setSalary(BigDecimal.valueOf(40000.99));

        Assertions.assertThat(salesmans).contains(salesmanDiego);
        Assertions.assertThat(salesmans).contains(salesmanRenato);
    }

}