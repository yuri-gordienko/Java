package yugo.persistence.sql.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import yugo.persistence.sql.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToMany(mappedBy = "productImages")
    private Set<Product> products = new HashSet<>();

    public ProductImage() {
        super();
        this.mainImage = false;
    }
}
