package file.reader.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private String id;
    private int quantity;
    private BigDecimal price;

}
