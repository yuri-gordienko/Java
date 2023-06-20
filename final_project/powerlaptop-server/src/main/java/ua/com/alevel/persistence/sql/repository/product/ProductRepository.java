package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

@Repository // говорим, что это Репозиторий
public interface ProductRepository extends BaseEntityRepository<Product> { }