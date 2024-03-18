package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.collections4.CollectionUtils;

import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductPDPDto {

    private Long id;
    private String productBrand;
    private String name;
    private String description;
    private Set<String> images;
    private String price = "100.00";
    private List<String> osList;
    private List<String> cpuList;
    private List<Integer> ramList;
    private List<Integer> ssdList;
    private List<String> colorList;
    private List<String> displayResolutionList;
    private List<DisplayType> displayTypeList;
    private List<String> displaySizeList;

    public ProductPDPDto(Product product, Collection<ProductVariant> productVariants) {
        this.id = product.getId();
        this.productBrand = product.getProductBrand().getBrandType();
        this.name = product.getName();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        if (CollectionUtils.isNotEmpty(productVariants)) {
            this.osList = productVariants.stream().map(ProductVariant::getOs).map(OsType::getType).distinct().toList();
            this.cpuList = productVariants.stream().map(ProductVariant::getCpu).distinct().toList();
            this.ramList = productVariants.stream().map(ProductVariant::getRam).distinct().toList();
            this.ssdList = productVariants.stream().map(ProductVariant::getSsd).distinct().toList();
            this.colorList = productVariants.stream().map(ProductVariant::getColor).distinct().toList();
            List<ProductDisplay> productDisplayList = productVariants.stream().map(ProductVariant::getProductDisplay).toList();
            if (CollectionUtils.isNotEmpty(productDisplayList)) {
                this.displayResolutionList = productDisplayList.stream().map(ProductDisplay::getDisplayResolution).distinct().toList();
                this.displayTypeList = productDisplayList.stream().map(ProductDisplay::getDisplayType).distinct().toList();
                this.displaySizeList = productDisplayList.stream().map(ProductDisplay::getDisplaySize).distinct().toList();
            }
        }
    }
}
