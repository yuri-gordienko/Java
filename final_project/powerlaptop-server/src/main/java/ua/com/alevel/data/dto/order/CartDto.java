package ua.com.alevel.data.dto.order;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CartDto {

    private Date created;
    private List<ProductOrderDto> entries;
    private String price;

    public CartDto(Cart cart, List<ProductVariant> productVariants) {
        this.created = cart.getCreated();
        this.entries = productVariants.stream().map(ProductOrderDto::new).toList();
    }
}
