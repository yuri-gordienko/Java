package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;

@Getter
@Setter
@NoArgsConstructor
public class ProductVariantDto extends BaseDto {

    private OsType os;
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String color;
    private String displayResolution;
    private DisplayType displayType;
    private String displaySize;

    public ProductVariantDto(ProductVariant productVariant) {
        setId(productVariant.getId());
        this.os = productVariant.getOs();
        this.cpu = productVariant.getCpu();
        this.ram = productVariant.getRam();
        this.ssd = productVariant.getSsd();
        this.color = productVariant.getColor();
        ProductDisplay productDisplay = productVariant.getProductDisplay();
        if (productDisplay != null) {
            this.displayResolution = productDisplay.getDisplayResolution();
            this.displayType = productDisplay.getDisplayType();
            this.displaySize = productDisplay.getDisplaySize();
        }
    }
}
