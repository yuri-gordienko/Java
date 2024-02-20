package ua.com.alevel.persistence.sql.type;

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
