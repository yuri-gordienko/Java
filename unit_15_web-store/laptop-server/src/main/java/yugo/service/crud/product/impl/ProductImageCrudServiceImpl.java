package yugo.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.persistence.sql.repository.product.ProductImageRepository;
import yugo.service.crud.product.ProductImageCrudService;
import yugo.util.IsValidFields;
import yugo.util.PersistenceUtil;

import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ProductImageCrudServiceImpl implements ProductImageCrudService {

    private final ProductImageRepository productImageRepository;
    private final IsValidFields isValidFields;

    @Override
    public void create(ProductImage entity) {
        productImageRepository.save(entity);
    }

    @Override
    public void update(ProductImage entity) {
        isValidFields.isValidId(entity.getId());
        productImageRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        isValidFields.isValidId(id);
        productImageRepository.deleteById(id);
    }

    @Override
    public ProductImage findById(Long id) {
        isValidFields.isValidId(id);
        return productImageRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest request) {

        return productImageRepository.findAll(PersistenceUtil.generatePageableByDataTableRequest(request));
    }

    @Override
    public Set<ProductImage> findAllByIdIn(Set<Long> ids) {

        return productImageRepository.findAllByIdIn(ids);
    }
}
