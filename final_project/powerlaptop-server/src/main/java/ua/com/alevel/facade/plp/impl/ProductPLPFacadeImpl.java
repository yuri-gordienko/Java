package ua.com.alevel.facade.plp.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.data.dto.product.ProductPLPDto;
import ua.com.alevel.facade.plp.ProductPLPFacade;
import ua.com.alevel.service.crud.product.ProductCrudService;

import java.util.Collection;

@Service
public class ProductPLPFacadeImpl implements ProductPLPFacade {

    private final ProductCrudService productCrudService;

    public ProductPLPFacadeImpl(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @Override
    public Collection<ProductPLPDto> findAll() {
        return productCrudService.findAll().stream().map(ProductPLPDto::new).toList();
    }
}
