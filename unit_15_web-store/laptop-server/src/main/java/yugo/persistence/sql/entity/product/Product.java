package yugo.persistence.sql.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import yugo.persistence.sql.entity.BaseEntity;
import yugo.util.types_of_laptops.ProductBrandType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_brand", nullable = false, updatable = false)
    private ProductBrandType productBrand;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "product_image",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_image_id")
    )
    private Set<ProductImage> productImages = new HashSet<>();
}
