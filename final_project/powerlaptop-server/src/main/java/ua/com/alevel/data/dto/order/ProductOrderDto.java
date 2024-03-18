package ua.com.alevel.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.DisplayType;

import java.util.Set;

@Getter
@Setter
public class ProductOrderDto {

    private Long id;
    private String productBrand;
    private String name;
    private String image;
    private String price = "100.00";
    private String os;
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String color;
    private String displayResolution;
    private DisplayType displayType;
    private String displaySize;
    private Integer quantity;

    public ProductOrderDto(ProductVariant productVariant) {
        this.id = productVariant.getId();
        this.os = productVariant.getOs().getType();
        this.price = productVariant.getPrice().toString();
        this.cpu = productVariant.getCpu();
        this.ram = productVariant.getRam();
        this.ssd = productVariant.getSsd();
        ProductDisplay productDisplay = productVariant.getProductDisplay();
        if (productDisplay != null) {
            this.displayResolution = productDisplay.getDisplayResolution();
            this.displayType = productDisplay.getDisplayType();
            this.displaySize = productDisplay.getDisplaySize();
        }
        Product product = productVariant.getProduct();
        if (product != null) {
            this.productBrand = product.getProductBrand().getBrandType();
            this.name = product.getName();
            Set<ProductImage> productImages = product.getProductImages();
            if (CollectionUtils.isNotEmpty(productImages)) {
                ProductImage productImage = productImages
                        .stream()
                        .filter(ProductImage::getMainImage)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("main image not found"));
                this.image = productImage.getImageUrl();
            }
        }
    }
}
