package file.reader.entities;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Salesman {

    private String cpf;
    private String name;
    private BigDecimal salary;

}
