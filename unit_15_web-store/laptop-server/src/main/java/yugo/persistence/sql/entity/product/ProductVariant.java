package yugo.persistence.sql.entity.product;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import yugo.persistence.sql.entity.BaseEntity;
import yugo.persistence.sql.type.DisplayType;
import yugo.persistence.sql.type.OsType;

@Getter
@Setter
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OsType os;

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer ssd;

    @Column(nullable = false)
    private String color;

    @Column(name = "display_resolution", nullable = false)
    private Integer displayResolution;

    @Enumerated(EnumType.STRING)
    @Column(name = "display_type", nullable = false)
    private DisplayType displayType;

    @ManyToOne
    private Product product;
}
