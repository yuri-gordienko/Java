package ua.com.alevel.facade.process;

import ua.com.alevel.data.dto.product.ProductProcessDto;

public interface ProductProcessFacade {

    void attach(Long id, ProductProcessDto dto);
    void detach(Long id, ProductProcessDto dto);
}
