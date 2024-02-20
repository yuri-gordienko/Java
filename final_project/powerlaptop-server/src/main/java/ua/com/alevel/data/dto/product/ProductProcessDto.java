package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductProcessDto {

    private Long productVariantId;
    private Set<Long> productImages;
}
