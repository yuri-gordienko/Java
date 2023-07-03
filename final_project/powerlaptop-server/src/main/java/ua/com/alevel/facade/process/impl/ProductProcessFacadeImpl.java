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

    private final ProductCrudService productCrudService;    // достаем продукт
    private final ProductVariantCrudService productVariantCrudService;  // достаем варианты
    private final ProductImageCrudService productImageCrudService;  // достаем картинки

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
        Product product = productCrudService.findById(id);  // нашли idшки
        ProductVariant productVariant = productVariantCrudService.findById(dto.getProductVariantId());
        Set<ProductImage> productImages = productImageCrudService.findAllByIdIn(dto.getProductImages());
        productVariant.setProduct(product); // продукт вариант засовываем в продукт
        productVariantCrudService.update(productVariant);   // обновляем продукт
        product.setProductImages(productImages); // картинку засовываем в продукт
        productCrudService.update(product); // обновляем картинку
    }

    @Override
    public void detach(Long id, ProductProcessDto dto) {
    }
}