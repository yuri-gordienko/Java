package yugo.service.crud.product;

import yugo.persistence.sql.entity.product.Product;
import yugo.service.crud.CrudService;

import java.util.Collection;

public interface ProductCrudService extends CrudService<Product> {

    Collection<Product> findAll();
}
