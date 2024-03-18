package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByCode(String code);
}
