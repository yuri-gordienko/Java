package ua.com.alevel.data.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;

@Getter
@Setter
@Builder
public class ProductSearchDto {

    private OsType os;
    private String cpu;
    private Integer ram;
    private Integer ssd;
    private String color;
    private String displayResolution;
    private DisplayType displayType;
    private String displaySize;
    private Long productId;
}
