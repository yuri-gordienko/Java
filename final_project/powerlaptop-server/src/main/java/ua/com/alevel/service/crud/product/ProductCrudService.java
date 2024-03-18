package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.service.crud.CrudService;

import java.util.Collection;

public interface ProductCrudService extends CrudService<Product> {

    Collection<Product> findAll();
}
