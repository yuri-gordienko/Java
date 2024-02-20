package ua.com.alevel.facade.process.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.data.dto.product.ProductProcessDto;
import ua.com.alevel.facade.process.ProductProcessFacade;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.product.ProductCrudService;
import ua.com.alevel.service.crud.product.ProductImageCrudService;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

import java.util.Set;

@Service
public class ProductProcessFacadeImpl implements ProductProcessFacade {

    private final ProductCrudService productCrudService;
    private final ProductVariantCrudService productVariantCrudService;
    private final ProductImageCrudService productImageCrudService;

    public ProductProcessFacadeImpl(
            ProductCrudService productCrudService,
            ProductVariantCrudService productVariantCrudService,
            ProductImageCrudService productImageCrudService) {
        this.productCrudService = productCrudService;
        this.productVariantCrudService = productVariantCrudService;
        this.productImageCrudService = productImageCrudService;
    }

    @Override
    public void attach(Long id, ProductProcessDto dto) {
        Product product = productCrudService.findById(id);
        ProductVariant productVariant = productVariantCrudService.findById(dto.getProductVariantId());
        Set<ProductImage> productImages = productImageCrudService.findAllByIdIn(dto.getProductImages());
        productVariant.setProduct(product);
        productVariantCrudService.update(productVariant);
        product.setProductImages(productImages);
        productCrudService.update(product);
    }

    @Override
    public void detach(Long id, ProductProcessDto dto) {

    }
}
