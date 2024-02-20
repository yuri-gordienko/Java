package ua.com.alevel.persistence.sql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.entity.product.Product;

@Getter
@Setter
public class ProductVariantMinDto {

    private String cpu;
    private String color;
    private Product product;

    public ProductVariantMinDto(String cpu, String color, Product product) {
        this.cpu = cpu;
        this.color = color;
        this.product = product;
    }
}
