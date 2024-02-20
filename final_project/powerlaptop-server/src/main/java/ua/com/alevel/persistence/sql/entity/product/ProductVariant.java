package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.OsType;

import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

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

    @Column(nullable = false)
    private String battery;

    @Column(nullable = false)
    private String camera;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String wireless;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double depth;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Product product;

    @ManyToOne
    private ProductDisplay productDisplay;
}
