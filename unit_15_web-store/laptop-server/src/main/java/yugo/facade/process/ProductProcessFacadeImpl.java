package yugo.facade.process;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import yugo.data.dto.product.ProductProcessDto;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.service.crud.product.ProductCrudService;
import yugo.service.crud.product.ProductImageCrudService;
import yugo.service.crud.product.ProductVariantCrudService;

import java.util.Set;

@Service
@AllArgsConstructor
public class ProductProcessFacadeImpl implements ProductProcessFacade {

    private final ProductCrudService productCrudService;
    private final ProductVariantCrudService productVariantCrudService;
    private final ProductImageCrudService productImageCrudService;

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
