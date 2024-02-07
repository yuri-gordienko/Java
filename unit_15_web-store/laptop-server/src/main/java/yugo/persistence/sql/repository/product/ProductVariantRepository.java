package yugo.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.persistence.sql.repository.BaseEntityRepository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);
}
