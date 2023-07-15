package ua.com.alevel.facade.pdp;

import ua.com.alevel.data.dto.product.ProductPDPDto;

public interface ProductPDPFacade {

    ProductPDPDto findById(Long id);
}