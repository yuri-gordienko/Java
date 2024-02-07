package yugo.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;

import yugo.persistence.sql.entity.product.ProductImage;
import yugo.persistence.sql.repository.BaseEntityRepository;

import java.util.Set;

@Repository
public interface ProductImageRepository extends BaseEntityRepository<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
