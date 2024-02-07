package yugo.service.crud.product;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.service.crud.CrudService;

import java.util.Collection;

public interface ProductVariantCrudService extends CrudService<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);
}
