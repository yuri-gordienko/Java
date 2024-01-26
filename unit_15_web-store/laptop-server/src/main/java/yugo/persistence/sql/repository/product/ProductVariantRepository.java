package yugo.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {
}
