package ua.com.alevel.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductPLPDto { // Product Listing Page - страница со списком товаров (Объектов), каждый объект имеет хар-ки

    private Long id;
    private ProductBrandType productBrand;
    private String name;
    private String image;
    private String price = "100.00";

//    для инициализации полей объекта, создаем конструктор
    public ProductPLPDto(Product product) { // получаем на вход объект Продукт, т.к именно он и представлен на странице-списке
        this.id = product.getId();  // тянем из БД по Продукту свойства под каждое поле
        this.productBrand = product.getProductBrand();
        this.name = product.getName();
        // говорим Хайбернейту какие картинки еще вытащить, т.к. связь Мени ту Мени, лейзи стратегия, чтоб не было Out of fMemory:
        Set<ProductImage> productImages = product.getProductImages(); // создаем новый массив картинок, которые привязали к Продукту
        if (CollectionUtils.isNotEmpty(productImages)) { // чтоб не было NullPointer, делаем проверку
            ProductImage productImage = productImages // обращаясь к класу ProductImage, тянем картинку, которая нам нужна
                    .stream()
                    .filter(ProductImage::getMainImage) // фильтром говорим какую картинку подтягивать
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("main image is not found"));
// orElseThrow - If a value is present, returns the value, otherwise throws an exception produced by the exception supplying function.
            this.image = productImage.getImageUrl(); // назначаем картинку
        }
    }
}
