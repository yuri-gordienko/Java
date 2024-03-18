package yugo.facade.pdp;

import yugo.data.dto.product.ProductPDPDto;

public interface ProductPDPFacade {

    ProductPDPDto findById(Long id);
}
