package yugo.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.util.types_of_laptops.ProductBrandType;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductPLPDto {

    private Long id;
    private ProductBrandType productBrand;
    private String name;
    private String image;
    private String price = "100.00";

    public ProductPLPDto(Product product) {
        this.id = product.getId();
        this.productBrand = product.getProductBrand();
        this.name = product.getName();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            ProductImage productImage = productImages
                .stream()
                .filter(ProductImage::getMainImage)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("main image is not found"));
            this.image = productImage.getImageUrl();
        }
    }
}
