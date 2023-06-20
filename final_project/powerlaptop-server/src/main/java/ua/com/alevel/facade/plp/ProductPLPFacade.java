package ua.com.alevel.facade.plp;

import ua.com.alevel.data.dto.product.ProductPLPDto;

import java.util.Collection;

public interface ProductPLPFacade {

    Collection<ProductPLPDto> findAll();
}
