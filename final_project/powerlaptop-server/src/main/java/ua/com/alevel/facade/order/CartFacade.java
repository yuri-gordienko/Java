package ua.com.alevel.facade.order;

import ua.com.alevel.data.dto.order.CartDto;
import ua.com.alevel.data.dto.order.CartEntryDto;

public interface CartFacade {

    CartDto findActive();
    void add(CartEntryDto dto);
    void update(CartEntryDto dto);
    void remove(CartEntryDto dto);
    void clear();
}
