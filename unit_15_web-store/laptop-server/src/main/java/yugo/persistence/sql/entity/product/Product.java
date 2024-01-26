package yugo.persistence.sql.entity.product;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import yugo.persistence.sql.entity.BaseEntity;
import yugo.persistence.sql.type.ProductBrandType;

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
}
