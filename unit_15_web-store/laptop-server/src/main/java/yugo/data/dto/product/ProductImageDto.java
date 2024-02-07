package yugo.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import yugo.data.dto.BaseDto;
import yugo.persistence.sql.entity.product.ProductImage;

@Getter
@Setter
@NoArgsConstructor
public class ProductImageDto extends BaseDto {

    private Boolean mainImage;
    private String imageUrl;

    public ProductImageDto(ProductImage productImage) {
        setId(productImage.getId());
        this.mainImage = productImage.getMainImage();
        this.imageUrl = productImage.getImageUrl();
    }
}
