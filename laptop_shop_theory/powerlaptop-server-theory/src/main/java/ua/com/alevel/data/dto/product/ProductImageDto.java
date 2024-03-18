package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;

@Getter
@Setter
@NoArgsConstructor
public class ProductImageDto extends BaseDto {

    private String imageUrl;
    private Boolean mainImage;

    public ProductImageDto(ProductImage productImage) {
        setId(productImage.getId());
        this.imageUrl = productImage.getImageUrl();
        this.mainImage = productImage.getMainImage();
    }
}
