package ua.com.alevel.service.order;

import ua.com.alevel.persistence.sql.entity.order.Cart;
import ua.com.alevel.persistence.sql.entity.order.CartEntry;

import java.util.List;

public interface CartService {

    void add(CartEntry cartEntry);
    void update(CartEntry cartEntry);
    void remove(CartEntry cartEntry);
    void clear();
    Cart getActive();
    List<CartEntry> findByCart(Cart cart);
}
