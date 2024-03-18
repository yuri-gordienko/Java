package yugo.service.crud.product;

import yugo.persistence.sql.entity.product.ProductImage;
import yugo.service.crud.CrudService;

import java.util.Set;

public interface ProductImageCrudService extends CrudService<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
