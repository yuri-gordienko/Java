package yugo.util.types_of_laptops;

import lombok.Getter;

@Getter
public enum ProductBrandType {

    APPLE("Apple"),
    DELL("DELL"),
    HP("HP"),
    THINK_PAD("ThinkPad");

    private final String brandType;

    ProductBrandType(String brandType) {

        this.brandType = brandType;
    }
}
