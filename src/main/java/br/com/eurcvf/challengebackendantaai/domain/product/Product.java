package br.com.eurcvf.challengebackendantaai.domain.product;

import br.com.eurcvf.challengebackendantaai.domain.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

    public Product(ProductDTO productDTO) {
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.ownerId = productDTO.ownerId();
        this.price = productDTO.price();
    }
}
