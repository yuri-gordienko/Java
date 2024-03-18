package yugo.util;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

import yugo.exception.FieldEmptyException;
import yugo.persistence.sql.entity.product.Product;

import static yugo.util.ExceptionUtil.*;
import static yugo.util.ExceptionUtil.ENTITY_ID_IS_INCORRECT;

@Service
public class IsValidFields {

    public void isValidProduct(Product entity) {   // метод для проверки метода в соответствии с тестами
        if (StringUtils.isBlank(entity.getName())) {
            throw new FieldEmptyException(PRODUCT_NAME_IS_NOT_PRESENT); // енамчики, что должна ответить прога на экзепшн
        }
        if (entity.getProductBrand() == null) {
            throw new FieldEmptyException(PRODUCT_BRAND_IS_NOT_PRESENT);
        }
    }

    public void isValidId(Long id) {
        if (id == null) {
            throw new FieldEmptyException(ENTITY_ID_IS_NOT_PRESENT);
        }
        if (id <= 0) {
            throw new FieldEmptyException(ENTITY_ID_IS_INCORRECT);
        }
    }
}
