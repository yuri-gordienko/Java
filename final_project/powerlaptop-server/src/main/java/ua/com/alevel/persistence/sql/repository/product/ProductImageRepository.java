package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Set;

@Repository
public interface ProductImageRepository extends BaseEntityRepository<ProductImage> {

    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
