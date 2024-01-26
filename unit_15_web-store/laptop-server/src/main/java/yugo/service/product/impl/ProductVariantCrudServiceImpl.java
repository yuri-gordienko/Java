package yugo.service.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yugo.data.DataTableRequest;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.service.product.ProductVariantCrudService;

@Service
@Transactional
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {
    @Override
    public void create(ProductVariant productVariant) {

    }

    @Override
    public void update(ProductVariant productVariant) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductVariant findById(Long id) {
        return null;
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return null;
    }
}
