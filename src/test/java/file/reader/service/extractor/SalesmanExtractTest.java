package file.reader.service.extractor;

import file.reader.entities.Salesman;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SalesmanExtractTest {

    @Test
    void testExtractToEntities_returnsSalesman() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("001ç3245678865434çRenatoç40000.99");

        List<Salesman> salesmans = SalesmanExtract.extractToEntities(lines);
        Assertions.assertThat(salesmans.size()).isEqualTo(2);

        Salesman salesman = salesmans.get(0);
        Assertions.assertThat(salesman.getCpf()).isEqualTo("1234567891234");
        Assertions.assertThat(salesman.getName()).isEqualTo("Diego");
        Assertions.assertThat(salesman.getSalary()).isEqualTo("50000.0");
    }

}