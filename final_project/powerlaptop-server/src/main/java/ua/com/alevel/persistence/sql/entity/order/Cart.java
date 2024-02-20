package ua.com.alevel.persistence.sql.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.entity.user.Personal;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {

    @Column(name = "active")
    private Boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;

    @ManyToOne
    private Personal personal;

    public Cart() {
        this.created = new Date();
        this.active = true;
    }
}
