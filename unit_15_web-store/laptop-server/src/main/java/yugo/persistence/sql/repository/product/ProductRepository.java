package yugo.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface ProductRepository extends BaseEntityRepository<Product> {
}
