package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

@Getter
@Setter
@NoArgsConstructor // необходим чтоб автоматически генерировать дефолтный конструктор (без агрументов)
public class ProductDto extends BaseDto {

    private String name;    // возвращаем клиенту ограниченную инфо
    private ProductBrandType productBrand;
    private String description;

    public ProductDto(Product product) {    // будет создаваться на базе продукта
        setId(product.getId()); // сетаем id
        this.name = product.getName();
        this.productBrand = product.getProductBrand();
        this.description = product.getDescription();
    }
}