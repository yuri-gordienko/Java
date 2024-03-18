package yugo.facade.pdp.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import yugo.data.dto.product.ProductPDPDto;
import yugo.facade.pdp.ProductPDPFacade;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.service.crud.product.ProductCrudService;
import yugo.service.crud.product.ProductVariantCrudService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPDPFacadeImpl implements ProductPDPFacade {

    private final ProductCrudService productCrudService;
    private final ProductVariantCrudService productVariantCrudService;

    @Override
    public ProductPDPDto findById(Long id) {
        Product product = productCrudService.findById(id);
        Collection<ProductVariant> productVariant = productVariantCrudService.findByProduct(product);
        return new ProductPDPDto(product, productVariant);
    }
}
