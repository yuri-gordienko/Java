package yugo.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import yugo.data.dto.BaseDto;
import yugo.persistence.sql.entity.product.Product;
import yugo.util.types_of_laptops.ProductBrandType;

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
