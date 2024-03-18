package ua.com.alevel.facade.pdp;

import ua.com.alevel.data.dto.product.ProductPDPDto;
import ua.com.alevel.data.dto.product.ProductSearchDto;

public interface ProductPDPFacade {

    ProductPDPDto findById(Long id);
    Long findProductIdByVariants(ProductSearchDto dto);
}
