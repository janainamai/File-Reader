package file.reader.service.extractor;

import file.reader.entities.Salesman;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Arrays.stream;

public class SalesmanExtract {

    private static final int CPF = 1;
    private static final int NAME = 2;
    private static final int SALARY = 3;

    public static List<Salesman> extractToEntities(List<String> linesOfSalesman) {
        return linesOfSalesman.stream()
                .map(SalesmanExtract::extactToSalesman)
                .toList();
    }

    private static Salesman extactToSalesman(String customerLine) {
        List<String> partsOfSalesman = stream(customerLine.split("ç")).toList();

        Salesman salesman = new Salesman();
        salesman.setCpf(partsOfSalesman.get(CPF));
        salesman.setName(partsOfSalesman.get(NAME));
        salesman.setSalary(BigDecimal.valueOf(parseDouble(partsOfSalesman.get(SALARY))));

        return salesman;
    }

}
