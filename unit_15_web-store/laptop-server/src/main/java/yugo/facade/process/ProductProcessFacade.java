package yugo.facade.process;

import yugo.data.dto.product.ProductProcessDto;

public interface ProductProcessFacade {

    void attach(Long id, ProductProcessDto dto);
    void detach(Long id, ProductProcessDto dto);
}
