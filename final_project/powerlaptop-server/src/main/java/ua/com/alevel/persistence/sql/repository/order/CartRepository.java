package ua.com.alevel.persistence.sql.repository.order;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.user.Personal;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Optional;

@Repository
public interface CartRepository extends BaseEntityRepository<Cart> {

    Optional<Cart> findByPersonalAndActiveTrue(Personal personal);
}
