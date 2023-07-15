package ua.com.alevel.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.Product;

import java.util.List;

@Getter
@Setter
public class ProductPageDto {

    private List<Product> products; // возвращаем лист продуктов
    private boolean hasNext;    // есть ли еще, что спрашивать
}