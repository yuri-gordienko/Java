package yugo.facade.plp.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yugo.data.dto.product.ProductPLPDto;
import yugo.facade.plp.ProductPLPFaсade;
import yugo.service.crud.product.ProductCrudService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPLPFaсadeImpl implements ProductPLPFaсade {

    private final ProductCrudService productCrudService;

    @Override
    public Collection<ProductPLPDto> findAll() {

        return productCrudService.findAll().stream().map(ProductPLPDto :: new).toList();
    }
}
