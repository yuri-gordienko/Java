package yugo.service.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yugo.data.DataTableRequest;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.service.product.ProductImageCrudService;

@Service
@Transactional
public class ProductImageCrudServiceImpl implements ProductImageCrudService {
    @Override
    public void create(ProductImage productImage) {

    }

    @Override
    public void update(ProductImage productImage) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductImage findById(Long id) {
        return null;
    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest request) {
        return null;
    }
}
