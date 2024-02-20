package ua.com.alevel.persistence.sql.entity.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;

@Getter
@Setter
@Entity
@Table(name = "cart_entries")
public class CartEntry extends BaseEntity {

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private ProductVariant productVariant;

    @Column(nullable = false)
    private Integer quantity;

    public CartEntry() {
        quantity = 0;
    }
}
