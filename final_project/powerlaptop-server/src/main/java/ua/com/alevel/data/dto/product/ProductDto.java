package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto extends BaseDto {

    private String name;
    private ProductBrandType productBrand;
    private String description;

    public ProductDto(Product product) {
        setId(product.getId());
        this.name = product.getName();
        this.productBrand = product.getProductBrand();
        this.description = product.getDescription();
    }
}
