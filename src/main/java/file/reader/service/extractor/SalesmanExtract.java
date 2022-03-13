package file.reader.service.extractor;

import file.reader.entities.Salesman;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Arrays.stream;

// 001çCPFçNameçSalary
// 001ç1234567891234çDiegoç50000
public class SalesmanExtract {

    private static final int cpf = 1;
    private static final int name = 2;
    private static final int salary = 3;

    public static List<Salesman> extract(List<String> linesOfSalesman) {
        return linesOfSalesman.stream()
                .map(SalesmanExtract::extactToSalesman)
                .toList();
    }

    private static Salesman extactToSalesman(String customerLine) {
        List<String> partsOfSalesman = stream(customerLine.split("ç")).toList();

        Salesman salesman = new Salesman();
        salesman.setCpf(partsOfSalesman.get(cpf));
        salesman.setName(partsOfSalesman.get(name));
        salesman.setSalary(BigDecimal.valueOf(parseDouble(partsOfSalesman.get(salary))));

        return salesman;
    }

}
