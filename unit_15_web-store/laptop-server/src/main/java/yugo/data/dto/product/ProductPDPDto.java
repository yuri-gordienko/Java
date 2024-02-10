package yugo.data.dto.product;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.util.types_of_laptops.DisplayType;
import yugo.util.types_of_laptops.OsType;
import yugo.util.types_of_laptops.ProductBrandType;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductPDPDto {

    private Long id;
    private String name;
    private ProductBrandType productBrand;
    private String description;
    private Set<String> images;
    private String price = "100.00";
    private OsType os;
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String color;
    private String displayResolution;
    private DisplayType displayType;
    private String displaySize;

    public ProductPDPDto(Product product, Collection<ProductVariant> productVariant) {
        this.id = product.getId();
        this.name = product.getName();
        this.productBrand = product.getProductBrand();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        this.os = productVariant.getOs();
        this.cpu = productVariant.getCpu();
        this.ram = productVariant.getRam();
        this.ssd = productVariant.getSsd();
        this.color = productVariant.getColor();
        this.displayResolution = productVariant.getDisplayResolution();
        this.displayType = productVariant.getDisplayType();
        this.displaySize = productVariant.getDisplaySize();
    }
}
