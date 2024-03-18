package ua.com.alevel.facade.pdp.impl;

import org.springframework.stereotype.Service;

import ua.com.alevel.data.dto.product.ProductPDPDto;
import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.facade.pdp.ProductPDPFacade;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.product.ProductCrudService;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

import java.util.Collection;

@Service
public class ProductPDPFacadeImpl implements ProductPDPFacade {

    private final ProductCrudService productCrudService;
    private final ProductVariantCrudService productVariantCrudService;

    public ProductPDPFacadeImpl(
            ProductCrudService productCrudService,
            ProductVariantCrudService productVariantCrudService) {
        this.productCrudService = productCrudService;
        this.productVariantCrudService = productVariantCrudService;
    }

    @Override
    public ProductPDPDto findById(Long id) {
        Product product = productCrudService.findById(id);
        Collection<ProductVariant> productVariants = productVariantCrudService.findByProduct(product);
        return new ProductPDPDto(product, productVariants);
    }

    @Override
    public Long findProductIdByVariants(ProductSearchDto dto) {
        return productVariantCrudService.findProductIdByVariants(dto);
    }
}
