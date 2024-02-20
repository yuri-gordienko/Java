package ua.com.alevel.service.crud.product;

import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.CrudService;

import java.util.Collection;

public interface ProductVariantCrudService extends CrudService<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);
    Long findProductIdByVariants(ProductSearchDto dto);
}
