package file.reader.entities;

import lombok.Data;

import java.util.List;

@Data
public class Sale {

    private String id;
    private List<Item> items;
    private String salesmanName;

}
