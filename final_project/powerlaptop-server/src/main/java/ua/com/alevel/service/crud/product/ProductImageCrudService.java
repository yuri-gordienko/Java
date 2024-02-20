package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.service.crud.CrudService;

import java.util.Set;

public interface ProductImageCrudService extends CrudService<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
