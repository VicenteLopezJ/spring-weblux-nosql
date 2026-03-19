package ap1.junior.vicente.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stock;
    private String brand;
    private String state;

}