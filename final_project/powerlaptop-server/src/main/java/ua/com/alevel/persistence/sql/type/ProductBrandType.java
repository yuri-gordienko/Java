package ua.com.alevel.persistence.sql.type;

import lombok.Getter;

@Getter // для того чтоб brandType вытаскивала именно название в скобочках "Apple", в классе DisplayType Геттер не нужен
public enum ProductBrandType {

    APPLE("Apple"),
    DELL("DELL"),
    HP("HP"),
    THINK_PAD("ThinkPad");

    private final String brandType; // пишем вместо new

    ProductBrandType(String brandType) {    // инициализируем
        this.brandType = brandType;
    }
}