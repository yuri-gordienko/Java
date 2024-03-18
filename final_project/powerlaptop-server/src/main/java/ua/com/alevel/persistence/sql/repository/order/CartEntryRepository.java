package ua.com.alevel.persistence.sql.repository.order;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.order.CartEntry;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.List;

@Repository
public interface CartEntryRepository extends BaseEntityRepository<CartEntry> {

    List<CartEntry> findAllByCart(Cart cart);
}
