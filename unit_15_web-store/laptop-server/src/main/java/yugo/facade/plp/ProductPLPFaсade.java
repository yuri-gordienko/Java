package yugo.facade.plp;

import yugo.data.dto.product.ProductPLPDto;

import java.util.Collection;

public interface ProductPLPFaсade {

    Collection<ProductPLPDto> findAll();
}
