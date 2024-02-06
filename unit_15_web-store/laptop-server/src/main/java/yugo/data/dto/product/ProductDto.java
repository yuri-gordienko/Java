package yugo.data.dto.product;

import lombok.Getter;
import lombok.Setter;
import yugo.data.dto.BaseDto;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.type.ProductBrandType;

@Getter
@Setter
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
