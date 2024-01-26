package yugo.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import yugo.persistence.sql.entity.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(name = "main_image", nullable = false)
    private Boolean mainImage;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    private Product product;

    private ProductImage() {
        super();
        this.mainImage = false;
    }
}
