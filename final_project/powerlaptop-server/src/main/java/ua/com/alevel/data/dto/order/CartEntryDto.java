package ua.com.alevel.data.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartEntryDto {

    private Long cartId;
    private Long productVariantId;
    private Integer quantity;
}
