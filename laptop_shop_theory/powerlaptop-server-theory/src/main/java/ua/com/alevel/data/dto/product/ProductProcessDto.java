package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductProcessDto {

    private Long productVariantId;  // это id варианта, которому присваиваем картинки (в Постмане делали такой запрос)
    private Set<Long> productImages;    // Maccив картинок принимает в качестве Set (в Постмане указывали их id в массиве [] через запятую)
}